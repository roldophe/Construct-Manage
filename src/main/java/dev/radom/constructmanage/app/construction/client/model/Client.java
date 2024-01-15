package dev.radom.constructmanage.app.construction.client.model;

import dev.radom.constructmanage.app.construction.project.model.Project;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    @Id
    private String code;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false, length = 15)
    private String contactNumber;
    @OneToMany(mappedBy = "client")
    private List<Project> projects;

}
