package dev.radom.constructmanage.api.construction.assignment.model;

import dev.radom.constructmanage.api.construction.employee.model.Employee;
import dev.radom.constructmanage.api.construction.employee.model.EmployeeDto;
import dev.radom.constructmanage.api.construction.project.model.Project;
import dev.radom.constructmanage.api.construction.project.model.ProjectDto;

import java.math.BigDecimal;
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
