package dev.radom.constructmanage.api.construction.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateEmployeeDto(@NotBlank @NotNull
                                String email,
                                String contact,
                                String imageUrl,
                                @NotBlank @NotNull
                                String empAddress,
                                @NotBlank @NotNull
                                String jobCode) {
}
