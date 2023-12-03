package dev.radom.constructmanage.dataInit;

import dev.radom.constructmanage.api.construction.repository.JobRepository;
import dev.radom.constructmanage.api.construction.repository.ProjectRepository;
import dev.radom.constructmanage.api.construction.model.Job;
import dev.radom.constructmanage.api.construction.model.Project;
import dev.radom.constructmanage.utils.GenerateCode;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class DataInit {

    private final JobRepository jobRepository;
    private final ProjectRepository projectRepository;

    @PostConstruct
    private void init() {
        // Create and save Job entities
//        createAndSaveJob("Programmer", 35.75F);
//        createAndSaveJob("Systems Analyst", 96.75F);
//        createAndSaveJob("Database Designer", 105F);
//        createAndSaveJob("Electrical Engineer", 84.5F);
//        createAndSaveJob("Mechanical Engineer", 67.9F);
//        createAndSaveJob("Civil Engineer", 55.78F);
//        createAndSaveJob("Clerical Support", 26.87F);
//        createAndSaveJob("DSS Analyst", 45.95F);
//        createAndSaveJob("Applications Designer", 48.1F);
//        createAndSaveJob("Bio Technician", 34.55F);
//        createAndSaveJob("General Support", 18.36F);

        // Create and save Project entities

//        createAndSaveProject("Evergreen", new BigDecimal("5700.0"));
//        createAndSaveProject("Amber Wave", new BigDecimal("4500.0"));
//        createAndSaveProject("Rolling Tide", new BigDecimal("6800.0"));
//        createAndSaveProject("Star flight", new BigDecimal("3500.0"));

    }

    private void createAndSaveJob(String description, Float chargeHour) {
        Job job = new Job();
        job.setCode("JOB-" + GenerateCode.generateCode());
        job.setDescription(description);
        job.setChargeHour(chargeHour);
        job.setLastUpdate(LocalDateTime.now());
        jobRepository.save(job);
    }

    private void createAndSaveProject(String name, BigDecimal budget) {
        Project project = new Project();
        project.setCode("PROJ-" + GenerateCode.generateCode());
        project.setName(name);
        project.setBudget(budget);
        projectRepository.save(project);
    }
}