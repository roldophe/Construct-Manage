package dev.radom.constructmanage.api.construction.employee.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String gender;
    private String position;
    private String employmentStatus;
    private BigDecimal salary;
    private LocalDate dateOfHire;
    private String avatar;
    @OneToOne(mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private EmployeeDetails employeeDetails;

}
