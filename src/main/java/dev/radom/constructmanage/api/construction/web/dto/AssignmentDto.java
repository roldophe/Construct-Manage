package dev.radom.constructmanage.api.construction.web.dto;

import java.time.LocalDate;

public record AssignmentDto(String uuid,
                            LocalDate date,
                            Float hours,
                            Double chargeHour,
                            Double charge,
                            String projCode,
                            String empUuid) {
}
