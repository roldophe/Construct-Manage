package dev.radom.constructmanage.api.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String uuid;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, unique = true, length = 80)
    private String email;

    @Column(nullable = false, length = 100, name = "encrypted_passwd")
    private String password;

    private String avatar;
    @Column(length = 10)
    private String verifiedCode;
    private Boolean isVerified;
    private Boolean isDeleted;
    private LocalDateTime creationAt;
    private LocalDateTime updatedAt;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;

    @Override
    public int hashCode() {
        return Objects.hash(id, uuid, username, email);
    }

}
