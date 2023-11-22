package dev.radom.constructmanage.api.user;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@Table(name = "roles")
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true, length = 50)
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns =
    @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "auth_id", referencedColumnName = "id"))
    private Set<Authority> authorities;

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

