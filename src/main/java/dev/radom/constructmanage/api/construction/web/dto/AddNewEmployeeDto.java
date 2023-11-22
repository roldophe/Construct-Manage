package dev.radom.constructmanage.api.construction.web.dto;

import java.time.LocalDate;

public record AddNewEmployeeDto(String firstName,
                                String lastName,
                                LocalDate dateOfBirth,
                                String email,
                                String contact,
                                String address,
                                String jobCode) {
}
