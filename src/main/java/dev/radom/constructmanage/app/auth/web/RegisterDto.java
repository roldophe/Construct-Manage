package dev.radom.constructmanage.app.auth.web;

import jakarta.validation.constraints.*;

import java.util.Set;

public record RegisterDto(@NotBlank
                          String username,
                          @NotBlank
                          @Email
                          String email,
                          @NotBlank
                          String password,
                          @NotBlank
                          @Size(min = 3)
                          String nickName,
                          @NotNull
                          @Size(min = 1)
                          Set<@Positive Integer> roleIds) {
}