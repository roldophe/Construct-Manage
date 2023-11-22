package dev.radom.constructmanage.api.construction.repository;

import dev.radom.constructmanage.api.construction.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project,String> {
    Optional<Project> findByCode(String number);
    Boolean existsByName(String name);
}
