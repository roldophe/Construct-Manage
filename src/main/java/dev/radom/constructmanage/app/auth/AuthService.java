package dev.radom.constructmanage.app.auth;

import dev.radom.constructmanage.app.auth.web.*;

public interface AuthService {
    AuthDto refreshToken(RefreshTokenDto refreshTokenDto);

    void register(RegisterDto registerDto) ;
    AuthDto login(LoginDto loginDto);
    void verify(VerifyDto verifyDto);
}
