package dev.radom.constructmanage.api.construction.employee.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record AddNewEmployeeDto(@Nullable
                                @NotBlank
                                @Size(min = 3, max = 25)
                                String firstName,
                                @Nullable
                                @NotBlank
                                @Size(min = 3, max = 25)
                                String lastName,
                                @NotNull
                                @Past
                                LocalDate dateOfBirth,
                                @Email
                                @Nullable
                                @NotBlank
                                @Size(min = 5, max = 50)
                                String email,
                                @Nullable
                                @NotBlank
                                @Size(min = 5, max = 15)
                                String contact,
                                @Nullable
                                @NotBlank
                                @Size(min = 5, max = 200)
                                String address,
                                @Nullable
                                @NotBlank
                                @Size(min = 6, max = 25)
                                String jobCode) {
}
