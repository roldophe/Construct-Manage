package dev.radom.constructmanage.app.auth.web;

import jakarta.validation.constraints.NotBlank;

public record LoginDto(@NotBlank
                       String username,
                       @NotBlank
                       String password) {

}