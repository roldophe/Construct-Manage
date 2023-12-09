package dev.radom.constructmanage.api.user;

import dev.radom.constructmanage.api.user.web.AddNewUserDto;
import dev.radom.constructmanage.api.user.web.UpdateUserDto;
import dev.radom.constructmanage.api.user.web.UserDto;
import org.mapstruct.*;

import java.lang.annotation.Target;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "roleIds", target = "roles", qualifiedByName = "mapRoleIdsToRoles")
    User fromAddNewUserDto(AddNewUserDto addNewUserDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromUpdateUserDto(@MappingTarget User user, UpdateUserDto updateUserDto);


    @Mapping(source = "roles", target = "roles")
    UserDto toUserDto(User user);

    List<UserDto> toSuUserDtoList(List<User> users);

    default List<String> mapRoles(Set<Role> roles) {
        return roles.stream()
                .map(Role::getName)
                .collect(Collectors.toList());
    }

    @Named("mapRoleIdsToRoles")
    default Set<Role> mapRoleIdsToRoles(Set<Integer> roleIds) {
        return roleIds.stream()
                .map(roleId -> {
                    Role role = new Role();
                    role.setId(roleId);
                    return role;
                })
                .collect(Collectors.toSet());
    }
}
