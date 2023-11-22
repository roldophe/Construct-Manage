package dev.radom.constructmanage.api.construction.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "jobs")
public class Job {
    @Id
    private String code;
    private String description;
    private Float chargeHour;
    private LocalDateTime lastUpdate;
    @OneToMany(mappedBy = "job")
    private List<Employee> employees ;
}
