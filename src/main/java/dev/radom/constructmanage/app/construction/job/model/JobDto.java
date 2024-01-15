package dev.radom.constructmanage.app.construction.job.model;

import java.time.LocalDateTime;

public record JobDto(String code,
                     String description,
                     LocalDateTime lastUpdate,
                     Float chargeHour) {
}
