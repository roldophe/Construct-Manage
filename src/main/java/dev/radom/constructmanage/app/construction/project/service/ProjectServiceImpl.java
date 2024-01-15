package dev.radom.constructmanage.app.construction.project.service;

import dev.radom.constructmanage.app.construction.project.repository.ProjectMapper;
import dev.radom.constructmanage.app.construction.project.repository.ProjectRepository;
import dev.radom.constructmanage.app.construction.project.model.Project;
import dev.radom.constructmanage.app.construction.project.dto.AddNewProjectDto;
import dev.radom.constructmanage.app.construction.project.model.ProjectDto;
import dev.radom.constructmanage.app.construction.project.dto.UpdateProjectDto;
import dev.radom.constructmanage.utils.RandomCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectMapper projectMapper;
    private final ProjectRepository projectRepository;

    @Override
    public void insertProject(AddNewProjectDto addNewProjectDto) {
        Boolean exist = projectRepository.existsByName(addNewProjectDto.name());
        if (exist) throw new ResponseStatusException(HttpStatus.CONFLICT, "Project already exist!!");
        Project project = projectMapper.fromUpdateProjectDto(addNewProjectDto);
        project.setCode("PROJ-" + RandomCode.generateCode());
        projectRepository.save(project);
    }

    @Override
    public void updateProjectByCode(String projCode, UpdateProjectDto updateProjectDto) {
        Project project = projectRepository.findByCode(projCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found!!"));
        projectMapper.fromUpdateProjectDto(project, updateProjectDto);
        projectRepository.save(project);
    }

    @Override
    public List<ProjectDto> findAllProjects() {
        return projectMapper.toProjectDtoList(projectRepository.findAll());
    }

    @Override
    public ProjectDto findProjectByCode(String projCode) {
        Project project = projectRepository.findByCode(projCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found!!"));
        return projectMapper.toProjectDto(project);
    }


    @Override
    public void deleteProjectByCode(String projCode) {
        Project project = projectRepository.findByCode(projCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found!!"));
        projectRepository.delete(project);
    }

    @Override
    public List<ProjectDto> findAllProjectByClientName(String name) {
        List<Project> projects = projectRepository.findAllByClientName(name);
               if (projects.isEmpty()){
                   throw new ResponseStatusException(HttpStatus.NOT_FOUND);
               }
        return projectMapper.toProjectDtoList(projects);
    }
}
