package dev.radom.constructmanage.api.construction.web.dto;

import java.time.LocalDateTime;

public record JobDto(String code,
                     String description,
                     LocalDateTime lastUpdate,
                     Float chargeHour) {
}
