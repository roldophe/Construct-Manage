package dev.radom.constructmanage.app.auth;

import dev.radom.constructmanage.app.auth.web.RegisterDto;
import dev.radom.constructmanage.app.user.web.AddNewUserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface AuthMapper {
    AddNewUserDto mapRegisterDtoToNewUserDto(RegisterDto registerDto);
}
