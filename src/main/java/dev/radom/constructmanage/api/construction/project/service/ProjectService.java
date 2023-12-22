package dev.radom.constructmanage.api.construction.project.service;

import dev.radom.constructmanage.api.construction.project.dto.AddNewProjectDto;
import dev.radom.constructmanage.api.construction.project.model.ProjectDto;
import dev.radom.constructmanage.api.construction.project.dto.UpdateProjectDto;

import java.util.List;

public interface ProjectService {
    void insertProject(AddNewProjectDto addNewProjectDto);

    void updateProjectByCode(String projCode, UpdateProjectDto updateProjectDto);

    List<ProjectDto> findAllProjects();

    ProjectDto findProjectByCode(String projCode);

    void deleteProjectByCode(String projCode);
    List<ProjectDto> findAllProjectByClientName(String name);
}
