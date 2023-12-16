package dev.radom.constructmanage.api.construction.web.dto;

import java.time.LocalDate;

public record AssignmentDetailsDto(String uuid,
                                   LocalDate date,
                                   String projCode,
                                   String empUuid,
                                   String jobCode,
                                   Float hours,
                                   Float chargeHour,
                                   Double charge) {
}
