package dev.radom.constructmanage.api.construction.web.dto;

import lombok.Builder;


public record ProjectAssignmentDTO(String projectCode,
                                   String projectName,
                                   String employeeUuid,
                                   String employeeName,
                                   String jobDescription,
                                   Float chargeHour,
                                   Float hours,
                                   Double charge) {
}
