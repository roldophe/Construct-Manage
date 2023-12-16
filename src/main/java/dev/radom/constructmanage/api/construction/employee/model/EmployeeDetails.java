package dev.radom.constructmanage.api.construction.employee.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Setter
@NoArgsConstructor
@Entity
@Table(name = "employee_details")
public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String emergencyContact;
    private String qualifications;
    private Integer experience;
    private String certifications;
    private String languageSpoken;
    private String performanceReviews;
    private String trainingHistory;
    private String leaveRecords;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @OneToMany(mappedBy = "employeeDetails", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BankAccountDetails> bankAccountDetails;

}
