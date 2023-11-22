package dev.radom.constructmanage.api.construction.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "projects")
public class Project {
    @Id
    private String code;
    private String name;
    private BigDecimal budget;

    @OneToMany(mappedBy = "project")
    private List<Assignment> assignments;
}