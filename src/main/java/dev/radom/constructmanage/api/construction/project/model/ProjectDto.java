package dev.radom.constructmanage.api.construction.project.model;

import java.math.BigDecimal;

public record ProjectDto(String code,
                         String name,
                         BigDecimal budget,
                         String client) {
}
