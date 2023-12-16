package dev.radom.constructmanage.api.construction.employee.repository;

import dev.radom.constructmanage.api.construction.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
