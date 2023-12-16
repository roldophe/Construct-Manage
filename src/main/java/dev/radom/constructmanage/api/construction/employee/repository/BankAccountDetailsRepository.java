package dev.radom.constructmanage.api.construction.employee.repository;

import dev.radom.constructmanage.api.construction.employee.model.BankAccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountDetailsRepository extends JpaRepository<BankAccountDetails,Long> {
}
