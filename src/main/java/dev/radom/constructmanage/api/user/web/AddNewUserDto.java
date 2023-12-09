package dev.radom.constructmanage.api.user.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;

public record AddNewUserDto(@NotBlank
                            @NotNull
                            @Size(min = 5, max = 50)
                            String username,
                            @NotBlank
                            @NotNull
                            @Size(min = 10, max = 80)
                            String email,
                            @NotBlank
                            @NotNull
                            @Size(min = 5, max = 100)
                            String password,
                            String avatar,
                            @NotNull
                            @Size(min = 1)
                            Set<Integer> roleIds) {
}
