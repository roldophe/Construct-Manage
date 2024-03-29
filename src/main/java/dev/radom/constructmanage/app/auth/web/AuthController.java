package dev.radom.constructmanage.app.auth.web;


import dev.radom.constructmanage.app.auth.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @Value("${app.base-uri}")
    private String appBaseUri;

    @PostMapping("/token")
    public AuthDto refreshToken(@Valid @RequestBody RefreshTokenDto refreshTokenDto) {
        return authService.refreshToken(refreshTokenDto);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> register(@Valid @RequestBody RegisterDto registerDto){
        authService.register(registerDto);
        return Map.of("message", "Please check email and verified...!",
                "verifyUri", appBaseUri + "auth/verify?email=" + registerDto.email());
    }

    @PostMapping("/verify")
    public Map<String, String> verifiedCode(@RequestBody VerifyDto verifyDto) {
        authService.verify(verifyDto);
        return Map.of("message", "Congratulation! Email has been verified..!");
    }

    @PostMapping("/login")
    public AuthDto login(@Valid @RequestBody LoginDto loginDto) {
        return authService.login(loginDto);
    }
}