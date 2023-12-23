package dev.radom.constructmanage.api.auth;

import dev.radom.constructmanage.api.auth.web.AuthDto;
import dev.radom.constructmanage.api.auth.web.LoginDto;
import dev.radom.constructmanage.api.auth.web.RegisterDto;
import dev.radom.constructmanage.api.auth.web.VerifyDto;
import jakarta.mail.MessagingException;

public interface AuthService {
    //AuthDto refreshToken(RefreshTokenDto refreshTokenDto);

    void register(RegisterDto registerDto) ;
    void login(LoginDto loginDto);
    void verify(VerifyDto verifyDto);
}
