package dev.radom.constructmanage.api.construction.web.dto;

import java.math.BigDecimal;

public record AddNewProjectDto(String name,
                               BigDecimal budget) {
}
