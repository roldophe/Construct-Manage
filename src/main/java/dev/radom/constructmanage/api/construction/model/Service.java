package dev.radom.constructmanage.api.construction.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "services")
public class Service {
    @Id
    private String code;

    @ManyToOne
    @JoinColumn(name = "org_code", referencedColumnName = "code")
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "id")
    private Employee employee;

}
