package dev.radom.constructmanage.app.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Boolean existsByUsernameAndIsDeletedFalse(String username);
    Boolean existsByEmailAndIsDeletedFalse(String email);
    Optional<User> findUserByUuidAndIsDeletedFalse(String uuid);
    List<User> findUserByIsDeletedTrue();
    Optional<User> findUserByUuid(String uuid);
    List<User> findUserByIsDeletedFalse();
    Boolean existsByUsernameOrEmail(String username,String email);
    Optional<User> findByUsernameAndIsDeletedFalseAndIsVerifiedTrue(String username);
}
