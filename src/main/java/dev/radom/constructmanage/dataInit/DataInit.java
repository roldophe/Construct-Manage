package dev.radom.constructmanage.dataInit;

import dev.radom.constructmanage.api.construction.job.model.Job;
import dev.radom.constructmanage.api.construction.job.repository.JobRepository;
import dev.radom.constructmanage.api.construction.project.model.Project;
import dev.radom.constructmanage.api.construction.project.repository.ProjectRepository;
import dev.radom.constructmanage.api.user.Authority;
import dev.radom.constructmanage.api.user.AuthorityRepository;
import dev.radom.constructmanage.api.user.Role;
import dev.radom.constructmanage.api.user.RoleRepository;
import dev.radom.constructmanage.utils.GenerateCode;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Component
@RequiredArgsConstructor
public class DataInit {

    private final JobRepository jobRepository;
    private final ProjectRepository projectRepository;
    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;

    @PostConstruct
    private void init() {
////         Create and save Job entities
        createAndSaveJob("Programmer", 35.75F);
        createAndSaveJob("Systems Analyst", 96.75F);
        createAndSaveJob("Database Designer", 105F);
        createAndSaveJob("Electrical Engineer", 84.5F);
        createAndSaveJob("Mechanical Engineer", 67.9F);
        createAndSaveJob("Civil Engineer", 55.78F);
        createAndSaveJob("Clerical Support", 26.87F);
        createAndSaveJob("DSS Analyst", 45.95F);
        createAndSaveJob("Applications Designer", 48.1F);
        createAndSaveJob("Bio Technician", 34.55F);
        createAndSaveJob("General Support", 18.36F);

        //// Create and save Project entities

        createAndSaveProject("Evergreen", new BigDecimal("5700.0"));
        createAndSaveProject("Amber Wave", new BigDecimal("4500.0"));
        createAndSaveProject("Rolling Tide", new BigDecimal("6800.0"));
        createAndSaveProject("Star flight", new BigDecimal("3500.0"));
        ////-------------------FOR USERS---------------------////


        Authority readAssignment = createAuthority("assignment:read");
        Authority writeAssignment = createAuthority("assignment:write");
        Authority updateAssignment = createAuthority("assignment:update");
        Authority deleteAssignment = createAuthority("assignment:delete");
        Set<Authority> authorityAssignments = Set.of(
                readAssignment, writeAssignment, updateAssignment, deleteAssignment
        );
        authorityRepository.saveAll(authorityAssignments);

        Authority readClient = createAuthority("client:read");
        Authority writeClient = createAuthority("client:write");
        Authority updateClient = createAuthority("client:update");
        Authority deleteClient = createAuthority("client:delete");
        Set<Authority> authorityClients = Set.of(
                readClient, writeClient, updateClient, deleteClient
        );
        authorityRepository.saveAll(authorityClients);

        Authority readProject = createAuthority("project:read");
        Authority writeProject = createAuthority("project:write");
        Authority updateProject = createAuthority("project:update");
        Authority deleteProject = createAuthority("project:delete");
        Set<Authority> authorityProjects = Set.of(
                readProject, writeProject, updateProject, deleteProject
        );
        authorityRepository.saveAll(authorityProjects);

        Authority readEmployee = createAuthority("employee:read");
        Authority writeEmployee = createAuthority("employee:write");
        Authority updateEmployee = createAuthority("employee:update");
        Authority deleteEmployee = createAuthority("employee:delete");

        Set<Authority> authorityEmployees = Set.of(
                readEmployee, writeEmployee, updateEmployee, deleteEmployee
        );

        authorityRepository.saveAll(authorityEmployees);
        //// Create and save Authority entities
        Authority readJob = createAuthority("job:read");
        Authority writeJob = createAuthority("job:write");
        Authority updateJob = createAuthority("job:update");
        Authority deleteJob = createAuthority("job:delete");
        Set<Authority> authorityJobs = Set.of(
                readJob, writeJob, updateJob, deleteJob
        );
        authorityRepository.saveAll(authorityJobs);

        Authority readUser = createAuthority("user:read");
        Authority writeUser = createAuthority("user:write");
        Authority updateUser = createAuthority("user:update");
        Authority deleteUser = createAuthority("user:delete");
        Authority profileUser = createAuthority("user:profile");
        Set<Authority> authorityUsers = Set.of(
                readUser, writeUser, updateUser, deleteUser, profileUser
        );
        authorityRepository.saveAll(authorityUsers);
        Set<Authority> fullAuthorities = new HashSet<>() {{
            addAll(authorityUsers);
            addAll(authorityJobs);
            addAll(authorityEmployees);
            addAll(authorityAssignments);
            addAll(authorityProjects);
            addAll(authorityClients);
        }};
        authorityRepository.saveAll(fullAuthorities);
        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        adminRole.setAuthorities(fullAuthorities);

        Role userRole = new Role();
        userRole.setName("USER");
        userRole.setAuthorities(Set.of(
                readProject, readAssignment, readClient, readJob, profileUser,
                writeProject, writeAssignment, writeClient,
                updateAssignment, updateProject, updateClient
        ));
        roleRepository.saveAll(List.of(adminRole, userRole));
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

    private Authority createAuthority(String name) {
        Authority authority = new Authority();
        authority.setName(name);
        return authority;
    }
}