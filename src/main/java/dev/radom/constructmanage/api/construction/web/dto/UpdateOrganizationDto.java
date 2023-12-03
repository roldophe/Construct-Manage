package dev.radom.constructmanage.api.construction.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record UpdateOrganizationDto(@NotBlank
                                    @NotNull
                                    Set<String> employeeUUIDs) {
}
