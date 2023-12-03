package dev.radom.constructmanage.api.construction.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UpdateEmployeeDto(@NotBlank @NotNull
                                String email,
                                String contact,
                                @NotBlank @NotNull
                                String empAddress,
                                @NotBlank @NotNull
                                String jobCode) {
}
