package dev.radom.constructmanage.api.construction.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "organizations")
public class Organization {
    @Id
    private String code;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false, length = 15)
    private String contactNumber;

    @ManyToMany()
    @JoinTable(name = "services",
            joinColumns = @JoinColumn(name = "org_code", referencedColumnName = "code"),
            inverseJoinColumns = @JoinColumn(name = "emp_id", referencedColumnName = "id"))
    private Set<Employee> employees;

}
