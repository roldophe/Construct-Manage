package dev.radom.constructmanage.api.construction.project.model;

import dev.radom.constructmanage.api.construction.assignment.model.Assignment;
import dev.radom.constructmanage.api.construction.client.model.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "projects")
@Builder
@AllArgsConstructor
public class Project {
    @Id
    private String code;
    private String name;
    private BigDecimal budget;

    @OneToMany(mappedBy = "project")
    private List<Assignment> assignments;
    @ManyToOne
    private Client client;
}
