package dev.radom.constructmanage.api.construction.employee.model;

import java.time.LocalDate;

public record EmployeeDto(String uuid,
                          String firstName,
                          String lastName,
                          LocalDate dateOfBirth,
                          LocalDate hireDate,
                          String email,
                          String contact,
                          String address,
                          String jobCode) {
}
