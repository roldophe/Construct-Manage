package dev.radom.constructmanage.app.construction.project.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record AddNewProjectDto(@Nullable
                               @NotBlank
                               @Size(min = 5, max = 50, message
                                       = "Name must be between 5 and 50 characters.")
                               String name,
                               @DecimalMin(value = "0.0", inclusive = false)
                               BigDecimal budget,
                               @Nullable
                               @NotBlank
                               @Size(min = 6, max = 25)
                               String clientCode) {
}
