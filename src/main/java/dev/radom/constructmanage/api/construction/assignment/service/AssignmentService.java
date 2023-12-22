package dev.radom.constructmanage.api.construction.assignment.service;

import dev.radom.constructmanage.api.construction.assignment.dto.AddNewAssignmentDto;
import dev.radom.constructmanage.api.construction.assignment.model.Assignment;
import dev.radom.constructmanage.api.construction.assignment.model.AssignmentDetailsDto;
import dev.radom.constructmanage.api.construction.assignment.model.AssignmentDto;
import dev.radom.constructmanage.api.construction.assignment.dto.UpdateAssignmentDto;

import java.util.List;

public interface AssignmentService {
    void createNewAssignment(AddNewAssignmentDto addNewAssignmentDto);
    void updateAssignmentByUuid(String uuid, UpdateAssignmentDto updateAssignmentDto);
    AssignmentDto findAssignmentByUuid(String uuid);
    List<AssignmentDto> findAllAssignments();
    void deleteAssignmentByUuid(String uuid);
    List<AssignmentDetailsDto> getAllAssignmentsWithDetails();
    AssignmentDetailsDto getAssignmentsWithDetailsByUuid(String uuid);
}
