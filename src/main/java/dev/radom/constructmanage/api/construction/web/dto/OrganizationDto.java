package dev.radom.constructmanage.api.construction.web.dto;

import java.util.Set;

public record OrganizationDto(String code,
                              String name,
                              String orgAddress,
                              String contactNumber,
                              Set<String> employeeUUIDs) {
}
