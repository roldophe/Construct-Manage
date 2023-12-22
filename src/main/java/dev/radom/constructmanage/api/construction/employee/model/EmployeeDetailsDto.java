package dev.radom.constructmanage.api.construction.employee.model;

import dev.radom.constructmanage.api.construction.job.model.Job;

import java.time.LocalDate;

public record EmployeeDetailsDto(String uuid,
                                 String firstName,
                                 String lastName,
                                 LocalDate dateOfBirth,
                                 LocalDate hireDate,
                                 String contact,
                                 String email,
                                 String address,
                                 String jobDescription,
                                 Float chargeHour) {
}
