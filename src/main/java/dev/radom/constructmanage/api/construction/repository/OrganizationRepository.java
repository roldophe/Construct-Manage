package dev.radom.constructmanage.api.construction.repository;

import dev.radom.constructmanage.api.construction.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
