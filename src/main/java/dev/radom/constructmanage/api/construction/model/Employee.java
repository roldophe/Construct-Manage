package dev.radom.constructmanage.api.construction.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
    private String empAddress;

    @ManyToOne
    @JoinColumn(name = "job_code")
    private Job job;

    @OneToMany(mappedBy = "employee")
    private List<Assignment> assignments;
}
