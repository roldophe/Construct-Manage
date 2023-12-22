package dev.radom.constructmanage.api.construction.job.model;

import java.time.LocalDateTime;

public record JobDto(String code,
                     String description,
                     LocalDateTime lastUpdate,
                     Float chargeHour) {
}
