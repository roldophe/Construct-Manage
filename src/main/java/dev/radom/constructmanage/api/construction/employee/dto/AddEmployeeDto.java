package dev.radom.constructmanage.api.construction.employee.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AddEmployeeDto(String firstName,
                             String lastName,
                             String email,
                             String phoneNumber,
                             LocalDate dateOfBirth,
                             String gender,
                             String position,
                             String employmentStatus,
                             BigDecimal salary,
                             LocalDate dateOfHire,
                             String avatar,
                             AddEmployeeDetailsDto employeeDetails ) {
}
