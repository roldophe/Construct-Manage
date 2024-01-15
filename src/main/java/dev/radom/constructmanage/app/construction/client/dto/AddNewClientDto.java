package dev.radom.constructmanage.app.construction.client.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AddNewClientDto(@Nullable
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
