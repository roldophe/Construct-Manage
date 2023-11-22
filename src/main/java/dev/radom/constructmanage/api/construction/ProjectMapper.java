package dev.radom.constructmanage.api.construction;

import dev.radom.constructmanage.api.construction.model.Project;
import dev.radom.constructmanage.api.construction.web.dto.AddNewProjectDto;
import dev.radom.constructmanage.api.construction.web.dto.ProjectDto;
import dev.radom.constructmanage.api.construction.web.dto.UpdateProjectDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    Project fromUpdateProjectDto(AddNewProjectDto addNewProjectDto);

    void fromUpdateProjectDto(@MappingTarget Project project, UpdateProjectDto updateProjectDto);

    List<ProjectDto> toProjectDtoList(List<Project> projects);

    ProjectDto toProjectDto(Project project);
}
