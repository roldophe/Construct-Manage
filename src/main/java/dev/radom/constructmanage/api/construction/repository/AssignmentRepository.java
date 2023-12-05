package dev.radom.constructmanage.api.construction.repository;

import dev.radom.constructmanage.api.construction.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface AssignmentRepository extends JpaRepository<Assignment,Long> {
    Optional<Assignment> findByUuid(String uuid);
    Boolean existsByProjectCodeAndEmployeeId(String code, Long id);
}
