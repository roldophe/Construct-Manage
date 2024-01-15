package dev.radom.constructmanage.app.construction.project.repository;

import dev.radom.constructmanage.app.construction.project.model.Project;
import dev.radom.constructmanage.app.construction.project.dto.AddNewProjectDto;
import dev.radom.constructmanage.app.construction.project.model.ProjectDto;
import dev.radom.constructmanage.app.construction.project.dto.UpdateProjectDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    @Mapping(source = "clientCode", target = "client.code")
    Project fromUpdateProjectDto(AddNewProjectDto addNewProjectDto);

    void fromUpdateProjectDto(@MappingTarget Project project, UpdateProjectDto updateProjectDto);

    List<ProjectDto> toProjectDtoList(List<Project> projects);

    @Mapping(source = "client.name", target = "client")
    ProjectDto toProjectDto(Project project);
}
