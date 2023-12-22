package dev.radom.constructmanage.api.construction.assignment.repository;

import dev.radom.constructmanage.api.construction.assignment.model.Assignment;
import dev.radom.constructmanage.api.construction.assignment.dto.AddNewAssignmentDto;
import dev.radom.constructmanage.api.construction.assignment.model.AssignmentDetailsDto;
import dev.radom.constructmanage.api.construction.assignment.model.AssignmentDto;
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
    @Mapping(source = "assignment.project.name",target = "projectName")
    @Mapping(source = "assignment.date",target = "assignDate")
    @Mapping(source = "assignment.project.client.name",target = "clientName")
    @Mapping(expression = "java(assignment.getEmployee().getFirstName() + \" \" + assignment.getEmployee().getLastName())",
            target = "employeeName")
    @Mapping(source = "assignment.employee.job.description",target = "jobDescription")
    AssignmentDetailsDto toAssignmentDetailsDto(Assignment assignment);
    List<AssignmentDetailsDto> toAssignmentDetailsDtoList(List<Assignment> assignments);

}
