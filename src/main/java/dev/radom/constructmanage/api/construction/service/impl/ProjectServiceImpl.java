package dev.radom.constructmanage.api.construction.service.impl;

import dev.radom.constructmanage.api.construction.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectServiceImpl implements ProjectService {
//    private final ProjectMapper projectMapper;
//    private final ProjectRepository projectRepository;
//
//    @Override
//    public void insertProject(AddNewProjectDto addNewProjectDto) {
//        Boolean exist = projectRepository.existsByName(addNewProjectDto.name());
//        if (exist) throw new ResponseStatusException(HttpStatus.CONFLICT, "Project already exist!!");
//        Project project = projectMapper.fromUpdateProjectDto(addNewProjectDto);
//        project.setCode("PROJ-" + GenerateCode.generateCode());
//        projectRepository.save(project);
//    }
//
//    @Override
//    public void updateProjectByCode(String projCode, UpdateProjectDto updateProjectDto) {
//        Project project = projectRepository.findByCode(projCode)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found!!"));
//        projectMapper.fromUpdateProjectDto(project, updateProjectDto);
//        projectRepository.save(project);
//    }
//
//    @Override
//    public List<ProjectDto> findAllProjects() {
//        return projectMapper.toProjectDtoList(projectRepository.findAll());
//    }
//
//    @Override
//    public ProjectDto findProjectByCode(String projCode) {
//        Project project = projectRepository.findByCode(projCode)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found!!"));
//        return projectMapper.toProjectDto(project);
//    }
//
//
//    @Override
//    public void deleteProjectByCode(String projCode) {
//        Project project = projectRepository.findByCode(projCode)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found!!"));
//        projectRepository.delete(project);
//    }
//
//    @Override
//    public List<ProjectAssignmentDTO> getProjectsByEmployeeUuid(String uuid) {
//        List<Object[]> results = projectRepository.findByEmployeeUuid(uuid);
//        return projectMapper.mapResultsToProjectAssignmentDtos(results);
//    }
//
//    @Override
//    public List<ProjectAssignmentDTO> getProjectsDetails() {
//        return projectMapper.mapResultsToProjectAssignmentDtos(projectRepository.getProjectsDetails());
//    }

}
