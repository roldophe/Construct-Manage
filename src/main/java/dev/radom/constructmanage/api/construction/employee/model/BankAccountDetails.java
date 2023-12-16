package dev.radom.constructmanage.api.construction.employee.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Entity
@Table(name = "bank_account_details")
public class BankAccountDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String accountNumber;
    private String bankName;
    private String accountType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_details_id")
    private EmployeeDetails employeeDetails;

}
