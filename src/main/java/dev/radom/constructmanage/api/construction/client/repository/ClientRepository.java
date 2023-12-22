package dev.radom.constructmanage.api.construction.client.repository;

import dev.radom.constructmanage.api.construction.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, String> {
    Optional<Client> findClientByCode(String code);
    Boolean existsByName(String name);
}
