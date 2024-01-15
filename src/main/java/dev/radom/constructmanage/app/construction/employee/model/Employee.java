package dev.radom.constructmanage.app.construction.employee.model;

import dev.radom.constructmanage.app.construction.assignment.model.Assignment;
import dev.radom.constructmanage.app.construction.job.model.Job;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String uuid;

    @Column(nullable = false, length = 25)
    private String firstName;
    @Column(nullable = false, length = 25)
    private String lastName;

    private LocalDate dateOfBirth;

    private LocalDate hireDate;

    @Column(nullable = false, length = 15)
    private String contact;

    @Column(nullable = false, unique = true, length = 80)
    private String email;

    @Column(nullable = false, length = 100)
    private String address;

    @ManyToOne
    @JoinColumn(name = "job_code")
    private Job job;

    @OneToMany(mappedBy = "employee")
    private List<Assignment> assignments;
}
