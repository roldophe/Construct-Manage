package dev.radom.constructmanage.api.construction.web.dto;

import java.math.BigDecimal;

public record ProjectDto(String code,
                         String name,
                         BigDecimal budget) {
}
