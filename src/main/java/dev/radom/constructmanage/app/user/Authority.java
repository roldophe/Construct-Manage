package dev.radom.constructmanage.app.user;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@Table(name = "authorities")
@Entity
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true, length = 50)
    private String name;
    @ManyToMany(mappedBy = "authorities", fetch = FetchType.EAGER)
    private Set<Role> roles;
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

