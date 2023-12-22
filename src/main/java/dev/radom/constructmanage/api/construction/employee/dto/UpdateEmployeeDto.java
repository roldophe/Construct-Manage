package dev.radom.constructmanage.api.construction.employee.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateEmployeeDto(@NotBlank @NotNull
                                String email,
                                String contact,
                                @NotBlank @NotNull
                                String address,
                                @NotBlank @NotNull
                                String jobCode) {
}
