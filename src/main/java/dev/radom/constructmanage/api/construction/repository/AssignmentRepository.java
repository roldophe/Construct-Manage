package dev.radom.constructmanage.api.construction.repository;

import dev.radom.constructmanage.api.construction.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface AssignmentRepository{
    // extends JpaRepository<Assignment, Long>
//    Optional<Assignment> findByUuid(String uuid);
//
//    Boolean existsByProjectCodeAndEmployeeId(String code, Long id);
//
//    @Query("""
//            SELECT a.uuid AS assign_uuid,
//            a.date AS assign_date,
//            p.code as proj_code,
//            e.uuid AS emp_uuid,
//            a.hours AS assign_hours,
//            j.code,
//            a.chargeHour AS assign_chg_hour,
//            a.charge AS assign_charge
//            FROM Assignment a
//            INNER JOIN Employee e
//            INNER JOIN Job j
//            inner join Project p""")
//    List<Assignment> findAllAssignmentDetail();
}
