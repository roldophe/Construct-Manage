package dev.radom.constructmanage.api.construction.web.dto;

import java.time.LocalDate;

public record EmployeeDto(String uuid,
                          String firstName,
                          String lastName,
                          LocalDate dateOfBirth,
                          LocalDate hireDate,
                          String email,
                          String contact,
                          String empAddress,
                          String jobCode) {
}
