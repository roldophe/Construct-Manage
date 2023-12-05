package dev.radom.constructmanage.api.construction.mapper;

import dev.radom.constructmanage.api.construction.model.Assignment;
import dev.radom.constructmanage.api.construction.web.dto.AddNewAssignmentDto;
import dev.radom.constructmanage.api.construction.web.dto.AssignmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AssignmentMapper {
    @Mapping(source = "projCode",target = "project.code")
    Assignment fromAddNewAssignment(AddNewAssignmentDto addNewAssignmentDto);
    List<AssignmentDto> toAssignmentDtosList(List<Assignment> assignments);
    @Mapping(source = "project.code",target = "projCode")
    @Mapping(source = "employee.uuid",target = "empUuid")
    AssignmentDto toAssignmentDto(Assignment assignment);
}
