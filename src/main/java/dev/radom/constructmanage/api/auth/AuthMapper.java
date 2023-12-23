package dev.radom.constructmanage.api.auth;

import dev.radom.constructmanage.api.auth.web.RegisterDto;
import dev.radom.constructmanage.api.user.web.AddNewUserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface AuthMapper {
    AddNewUserDto mapRegisterDtoToNewUserDto(RegisterDto registerDto);
}
