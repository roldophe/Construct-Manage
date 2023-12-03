package dev.radom.constructmanage.api.construction.repository;

import dev.radom.constructmanage.api.construction.model.Organization;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<Organization, String> {
    @EntityGraph(attributePaths = "employees")
    Optional<Organization> findOrganizationByCode(String code);
    Boolean existsByName(String name);
}
