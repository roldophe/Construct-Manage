package dev.radom.constructmanage.api.construction.service.impl;

import dev.radom.constructmanage.api.construction.mapper.ProjectMapper;
import dev.radom.constructmanage.api.construction.repository.ProjectRepository;
import dev.radom.constructmanage.api.construction.model.Project;
import dev.radom.constructmanage.api.construction.service.ProjectService;
import dev.radom.constructmanage.api.construction.web.dto.AddNewProjectDto;
import dev.radom.constructmanage.api.construction.web.dto.ProjectDto;
import dev.radom.constructmanage.api.construction.web.dto.UpdateProjectDto;
import dev.radom.constructmanage.utils.GenerateCode;
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
        project.setCode("PROJ-" + GenerateCode.generateCode());
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
}
