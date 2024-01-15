package dev.radom.constructmanage.app.construction.job.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AddNewJobDto(@NotNull
                           @NotBlank
                           String description,
                           @Positive
                           Float chargeHour) {
}
