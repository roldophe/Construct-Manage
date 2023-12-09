package dev.radom.constructmanage.api.user;

import dev.radom.constructmanage.api.user.web.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByUuidAndIsDeletedFalse(String uuid);
    List<User> findUserByIsDeletedTrue();
    Optional<User> findUserByUuid(String uuid);
    List<User> findUserByIsDeletedFalse();
    Boolean existsByUsernameOrEmail(String username,String email);
}
