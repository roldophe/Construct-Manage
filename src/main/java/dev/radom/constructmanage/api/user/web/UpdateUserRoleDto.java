package dev.radom.constructmanage.api.user.web;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;

public record UpdateUserRoleDto(@NotNull
                                @Size(min = 1)
                                Set<Integer> roleIds) {
}
