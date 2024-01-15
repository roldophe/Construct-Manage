package dev.radom.constructmanage.app.construction.assignment.dto;

import jakarta.validation.constraints.Positive;

public record UpdateAssignmentDto(@Positive
                                  Float hours) {
}
