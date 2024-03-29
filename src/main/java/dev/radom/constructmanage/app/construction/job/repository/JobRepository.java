package dev.radom.constructmanage.app.construction.job.repository;

import dev.radom.constructmanage.app.construction.job.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobRepository extends JpaRepository<Job,String> {
    Optional<Job> findJobByCode(String code);
    Boolean existsByDescription(String desc);
}
