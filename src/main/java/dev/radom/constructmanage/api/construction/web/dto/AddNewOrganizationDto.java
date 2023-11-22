package dev.radom.constructmanage.api.construction.web.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AddNewOrganizationDto(@Nullable
                                    @NotBlank
                                    @Size(min = 5, max = 100)
                                    String name,
                                    @Nullable
                                    @NotBlank
                                    @Size(min = 5, max = 100)
                                    String address,
                                    @Nullable
                                    @NotBlank
                                    @Size(min = 5, max = 15)
                                    String contactNumber) {
}
