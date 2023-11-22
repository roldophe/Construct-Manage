package dev.radom.constructmanage.api.construction;

import dev.radom.constructmanage.api.construction.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    Optional<Employee> findByUuid(String uuid);
    Boolean existsByEmailAndFirstNameAndLastName(String email,String firstName,String lastName);
    Boolean existsEmployeesByEmail(String email);
}
