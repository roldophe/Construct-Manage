package dev.radom.constructmanage.api.construction.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

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

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    private List<Service> services;

}
