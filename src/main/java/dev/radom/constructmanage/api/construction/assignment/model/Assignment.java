package dev.radom.constructmanage.api.construction.assignment.model;

import dev.radom.constructmanage.api.construction.employee.model.Employee;
import dev.radom.constructmanage.api.construction.project.model.Project;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "assignments")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String uuid;

    @Column(name = "assign_date")
    private LocalDate date;

    private Float hours;
    private Float chargeHour;
    private Double charge;

    @ManyToOne
    @JoinColumn(name = "PROJ_CODE")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "EMP_ID")
    private Employee employee;

}
