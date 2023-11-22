package dev.radom.constructmanage.api.construction.web.dto;

import java.time.LocalDate;

public record UpdateEmployeeDto(String email,
                                String contact,
                                String address,
                                String jobCode) {
}
