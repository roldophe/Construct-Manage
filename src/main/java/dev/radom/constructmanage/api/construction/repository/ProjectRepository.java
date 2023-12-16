package dev.radom.constructmanage.api.construction.repository;

import dev.radom.constructmanage.api.construction.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository  {
//    extends JpaRepository<Project, String>
//    Optional<Project> findByCode(String number);
//
//    Boolean existsByName(String name);
//
//    @Query("SELECT p.code AS proj_code, p.name AS proj_name, e.uuid AS emp_uuid, CONCAT(e.firstName, ' ', e.lastName) AS emp_name, j.description AS job_desc, j.chargeHour, a.hours, a.charge " +
//           "FROM Project p " +
//           "INNER JOIN p.assignments a " +
//           "INNER JOIN a.employee e " +
//           "INNER JOIN e.job j " +
//           "WHERE e.uuid = :uuid")
//    List<Object[]> findByEmployeeUuid(@Param("uuid") String uuid);
//
//    @Query("""
//            SELECT p.code AS proj_code,
//            p.name AS proj_name,
//            e.uuid AS emp_uuid, CONCAT(e.firstName, ' ', e.lastName) AS emp_name,
//            j.description AS job_desc, j.chargeHour,
//            a.hours, a.charge
//            FROM Project p
//            INNER JOIN p.assignments a
//            INNER JOIN a.employee e
//            INNER JOIN e.job j""")
//    List<Object[]> getProjectsDetails();

}
