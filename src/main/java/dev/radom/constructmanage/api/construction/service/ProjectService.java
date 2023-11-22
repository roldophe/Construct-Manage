package dev.radom.constructmanage.api.construction.service;

import dev.radom.constructmanage.api.construction.web.dto.AddNewProjectDto;
import dev.radom.constructmanage.api.construction.web.dto.ProjectDto;
import dev.radom.constructmanage.api.construction.web.dto.UpdateProjectDto;

import java.util.List;

public interface ProjectService {
    void insertProject(AddNewProjectDto addNewProjectDto);

    void updateProjectByCode(String projCode, UpdateProjectDto updateProjectDto);

    List<ProjectDto> findAllProjects();

    ProjectDto findProjectByCode(String projCode);

    void deleteProjectByCode(String projCode);
}
