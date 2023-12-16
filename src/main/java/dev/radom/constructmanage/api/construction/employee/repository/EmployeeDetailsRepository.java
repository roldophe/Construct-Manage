package dev.radom.constructmanage.api.construction.employee.repository;

import dev.radom.constructmanage.api.construction.employee.model.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails,Long> {
}
