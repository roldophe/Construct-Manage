package dev.radom.constructmanage.app.user.service;

import dev.radom.constructmanage.app.user.web.AddNewUserDto;
import dev.radom.constructmanage.app.user.web.UpdateUserDto;
import dev.radom.constructmanage.app.user.web.UpdateUserRoleDto;
import dev.radom.constructmanage.app.user.web.UserDto;
import org.springframework.security.core.Authentication;

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
    UserDto me(Authentication authentication );
}
