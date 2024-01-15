package dev.radom.constructmanage.app.user.service;

import dev.radom.constructmanage.app.user.*;
import dev.radom.constructmanage.app.user.web.AddNewUserDto;
import dev.radom.constructmanage.app.user.web.UpdateUserDto;
import dev.radom.constructmanage.app.user.web.UpdateUserRoleDto;
import dev.radom.constructmanage.app.user.web.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void addNewUser(AddNewUserDto addNewUserDto) {
        //Check username if exits
        if (userRepository.existsByUsernameAndIsDeletedFalse(addNewUserDto.username())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exits..!");
        }
        //Check email if exist
        if (userRepository.existsByEmailAndIsDeletedFalse(addNewUserDto.email())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exits..!");
        }
        boolean isNotFound = addNewUserDto.roleIds().stream()
                .anyMatch(roleId -> !roleRepository.existsById(roleId));
        if (isNotFound) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Role ID doesn't exits in db!");
        }

        Set<Role> roles = addNewUserDto.roleIds().stream()
                .map(roleId -> Role.builder().id(roleId).build())
                .collect(Collectors.toSet());
        User user = userMapper.fromAddNewUserDto(addNewUserDto);
        user.setUuid(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(addNewUserDto.password()));
        user.setIsVerified(false);
        user.setIsDeleted(false);
        user.setRoles(roles);
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

    @Override
    public UserDto me(Authentication authentication) {
        Jwt jwt = (Jwt) authentication.getPrincipal();
//        log.info("Jwt Subject = {}", jwt.getSubject());
//        log.info("Jwt Id = {}", jwt.getId());
        User user = userRepository.findByUsernameAndIsDeletedFalseAndIsVerifiedTrue(jwt.getId())
                .orElseThrow(() -> new UsernameNotFoundException("User is not found!"));
        return userMapper.toUserDto(user);
    }
}
