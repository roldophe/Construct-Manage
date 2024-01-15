package dev.radom.constructmanage.app.auth.web;

import jakarta.validation.constraints.NotBlank;

public record RefreshTokenDto(@NotBlank
                              String refreshToken) {
}