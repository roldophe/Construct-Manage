package dev.radom.constructmanage.app.construction.project.repository;

import dev.radom.constructmanage.app.construction.project.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project,String> {
    Optional<Project> findByCode(String number);
    Boolean existsByName(String name);

    List<Project> findAllByClientName(String name);
}
