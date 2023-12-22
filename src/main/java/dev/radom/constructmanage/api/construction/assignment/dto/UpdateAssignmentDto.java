package dev.radom.constructmanage.api.construction.assignment.dto;

import jakarta.validation.constraints.Positive;

public record UpdateAssignmentDto(@Positive
                                  Float hours) {
}
