package dev.radom.constructmanage.api.construction.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
//@Entity
//@Table(name = "employees")
public class Employee implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String uuid;

    @Column(nullable = false, length = 25)
    private String firstName;
    @Column(nullable = false, length = 25)
    private String lastName;

    private LocalDate dateOfBirth;

    private LocalDate hireDate;

    @Column(nullable = false, length = 15)
    private String contact;

    @Column(nullable = false,length = 80)
    private String email;
    private String imageUrl;
    @Column(nullable = false, length = 100)
    private String empAddress;
//
//    @ManyToOne
//    @JoinColumn(name = "job_code")
//    private Job job;
//
//    @OneToMany(mappedBy = "employee")
//    private List<Assignment> assignments;
}
