package dev.radom.constructmanage.api.construction.web.dto;

import jakarta.validation.constraints.Positive;

public record UpdateAssignmentDto(@Positive
                                  Float hours) {
}
