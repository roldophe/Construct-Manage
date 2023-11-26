package dev.radom.constructmanage.api.construction.web.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record AddNewProjectDto(@Nullable
                               @NotBlank
                               @Size(min = 5, max = 50, message
                                       = "Name must be between 5 and 50 characters.")
                               String name,
                               @DecimalMin(value = "0.0", inclusive = false)
                               @Digits(integer = 3, fraction = 2)
                               BigDecimal budget) {
}
