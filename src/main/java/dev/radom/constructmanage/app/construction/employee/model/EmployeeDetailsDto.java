package dev.radom.constructmanage.app.construction.employee.model;

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
