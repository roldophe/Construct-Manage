package dev.radom.constructmanage.api.construction.repository;

import dev.radom.constructmanage.api.construction.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<Organization, String> {
    Optional<Organization> findByCode(String code);

    Boolean existsByName(String name);
}
