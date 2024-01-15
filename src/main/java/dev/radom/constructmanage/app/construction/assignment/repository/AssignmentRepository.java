package dev.radom.constructmanage.app.construction.assignment.repository;

import dev.radom.constructmanage.app.construction.assignment.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssignmentRepository extends JpaRepository<Assignment,Long> {
    Optional<Assignment> findByUuid(String uuid);
    Boolean existsByProjectCodeAndEmployeeId(String code, Long id);
}
