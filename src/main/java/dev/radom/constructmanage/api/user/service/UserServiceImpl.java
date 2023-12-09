package dev.radom.constructmanage.api.user.service;

import dev.radom.constructmanage.api.user.Role;
import dev.radom.constructmanage.api.user.User;
import dev.radom.constructmanage.api.user.UserMapper;
import dev.radom.constructmanage.api.user.UserRepository;
import dev.radom.constructmanage.api.user.web.AddNewUserDto;
import dev.radom.constructmanage.api.user.web.UpdateUserDto;
import dev.radom.constructmanage.api.user.web.UpdateUserRoleDto;
import dev.radom.constructmanage.api.user.web.UserDto;
import dev.radom.constructmanage.utils.GenerateCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void addNewUser(AddNewUserDto addNewUserDto) {
        Boolean exists = userRepository.existsByUsernameOrEmail(addNewUserDto.username(), addNewUserDto.email());
        if (exists) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username or email already exist!!");
        }
        User user = userMapper.fromAddNewUserDto(addNewUserDto);
        user.setUuid(UUID.randomUUID().toString());
        user.setIsVerified(false);
        user.setIsDeleted(false);
        user.setVerifiedCode(GenerateCode.generateCode());
        user.setCreationAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);
    }

    @Override
    public void updateUserByUuid(String uuid, UpdateUserDto updateUserDto) {
        User isFound = userRepository.findUserByUuidAndIsDeletedFalse(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Uuid does not exist!!"));
        Boolean exists = userRepository.existsByUsernameOrEmail(updateUserDto.username(), updateUserDto.email());
        if (exists) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username or email already exist!!");
        }
        userMapper.fromUpdateUserDto(isFound, updateUserDto);
        isFound.setUpdatedAt(LocalDateTime.now());
        userRepository.save(isFound);
    }

    @Override
    public void updateUserIsDeletedByUuid(String uuid, Boolean updateIsDeleted) {
        User isFound = userRepository.findUserByUuid(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Uuid does not exist!!"));
        isFound.setIsDeleted(updateIsDeleted);
        userRepository.save(isFound);
    }

    @Override
    public void UpdateUserRoleByUuid(String uuid, UpdateUserRoleDto updateUserRoleDto) {
        User isFound = userRepository.findUserByUuidAndIsDeletedFalse(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Uuid does not exist!!"));
        Set<Role> updateUserRoles = userMapper.mapRoleIdsToRoles(updateUserRoleDto.roleIds());
        isFound.setRoles(updateUserRoles);
        isFound.setUpdatedAt(LocalDateTime.now());
        userRepository.save(isFound);
    }

    @Override
    public void deleteUserByUuid(String uuid) {
        User user = userRepository.findUserByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        userRepository.save(user);
    }

    @Override
    public UserDto findUserByUuid(String uuid) {
        return userMapper.toUserDto(userRepository.findUserByUuidAndIsDeletedFalse(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));

    }

    @Override
    public List<UserDto> findAllUser() {
        return userMapper.toSuUserDtoList(userRepository.findUserByIsDeletedFalse());
    }

    @Override
    public List<UserDto> findAllUserIsDeleted() {
        return userMapper.toSuUserDtoList(userRepository.findUserByIsDeletedTrue());
    }
}
