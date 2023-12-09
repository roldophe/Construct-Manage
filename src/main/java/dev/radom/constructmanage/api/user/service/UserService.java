package dev.radom.constructmanage.api.user.service;

import dev.radom.constructmanage.api.user.web.AddNewUserDto;
import dev.radom.constructmanage.api.user.web.UpdateUserDto;
import dev.radom.constructmanage.api.user.web.UpdateUserRoleDto;
import dev.radom.constructmanage.api.user.web.UserDto;

import java.util.List;

public interface UserService {
    void addNewUser(AddNewUserDto addNewUserDto);
    void updateUserByUuid(String uuid, UpdateUserDto updateUserDto);
    void updateUserIsDeletedByUuid(String uuid, Boolean updateIsDeleted);
    void UpdateUserRoleByUuid(String uuid, UpdateUserRoleDto updateUserRoleDto);
    void deleteUserByUuid(String uuid);
    UserDto findUserByUuid(String uuid);
    List<UserDto> findAllUser();
    List<UserDto> findAllUserIsDeleted();
}
