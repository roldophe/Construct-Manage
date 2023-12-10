package dev.radom.constructmanage.api.construction.mapper;

import dev.radom.constructmanage.api.construction.model.Project;
import dev.radom.constructmanage.api.construction.web.dto.AddNewProjectDto;
import dev.radom.constructmanage.api.construction.web.dto.ProjectAssignmentDTO;
import dev.radom.constructmanage.api.construction.web.dto.ProjectDto;
import dev.radom.constructmanage.api.construction.web.dto.UpdateProjectDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    Project fromUpdateProjectDto(AddNewProjectDto addNewProjectDto);

    void fromUpdateProjectDto(@MappingTarget Project project, UpdateProjectDto updateProjectDto);

    List<ProjectDto> toProjectDtoList(List<Project> projects);

    ProjectDto toProjectDto(Project project);

    default List<ProjectAssignmentDTO> mapResultsToProjectAssignmentDtos(List<Object[]> results) {
        return results.stream()
                .map(result -> new ProjectAssignmentDTO(
                        (String) result[0],
                        (String) result[1],
                        (String) result[2],
                        (String) result[3],
                        (String) result[4],
                        (Float) result[5],
                        (Float) result[6],
                        (Double) result[7]
                ))
                .collect(Collectors.toList());
    }
}

