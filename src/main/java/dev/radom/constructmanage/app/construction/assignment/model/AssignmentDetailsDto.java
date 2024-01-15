package dev.radom.constructmanage.app.construction.assignment.model;

import java.time.LocalDate;

public record AssignmentDetailsDto(String uuid,
                                   LocalDate assignDate,
                                   String projectName,
                                   String clientName,
                                   String employeeName,
                                   String jobDescription,
                                   Float hours,
                                   Float chargeHour,
                                   Double charge) {
}
