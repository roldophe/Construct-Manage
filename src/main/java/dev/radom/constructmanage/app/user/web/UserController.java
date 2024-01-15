package dev.radom.constructmanage.app.user.web;

import dev.radom.constructmanage.app.user.service.UserService;
import dev.radom.constructmanage.utils.UpdateStatusDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController{
    private final UserService userService;
    @GetMapping("/me")
    public UserDto me(Authentication authentication) {
        return userService.me(authentication);
    }
    @PostMapping
    public void createUser(@RequestBody AddNewUserDto createUserDto) {
        userService.addNewUser(createUserDto);
    }

    @GetMapping
    public List<UserDto> findAllUsers() {
        return userService.findAllUser();
    }

    @GetMapping("/{uuid}")
    public UserDto findUserByUuid(@PathVariable String uuid) {
        return userService.findUserByUuid(uuid);
    }

    @DeleteMapping("/{uuid}")
    public void deleteUserByUuid(@PathVariable String uuid) {
        userService.deleteUserByUuid(uuid);
    }

    @PatchMapping("/{uuid}")
    public void updateUserByUud(@PathVariable String uuid, @RequestBody UpdateUserDto updateUserDto) {
        userService.updateUserByUuid(uuid, updateUserDto);
    }

    @PutMapping("role/{uuid}")
    public void updateRoleUserByUud(@PathVariable String uuid, @RequestBody UpdateUserRoleDto updateUserRoleDto) {
        userService.UpdateUserRoleByUuid(uuid, updateUserRoleDto);
    }


    @GetMapping("/isDeleted")
    public List<UserDto> findAllUserIsDeleted() {
        return userService.findAllUserIsDeleted();
    }

    @PutMapping("/status/{uuid}")
    public void updateUserIsDeletedByUuid(@PathVariable String uuid, @RequestBody UpdateStatusDto updateStatus) {
        userService.updateUserIsDeletedByUuid(uuid, updateStatus.status());
    }
}