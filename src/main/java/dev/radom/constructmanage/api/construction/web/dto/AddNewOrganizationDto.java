package dev.radom.constructmanage.api.construction.web.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Set;

public record AddNewOrganizationDto(@Nullable
                                    @NotBlank
                                    @Size(min = 5, max = 100)
                                    String name,
                                    @Nullable
                                    @NotBlank
                                    @Size(min = 5, max = 100)
                                    String orgAddress,
                                    @Nullable
                                    @NotBlank
                                    @Size(min = 5, max = 15)
                                    String contactNumber,
                                    Set<String> employeeUUIDs) {
}
