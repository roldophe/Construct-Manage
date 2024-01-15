package dev.radom.constructmanage.app.construction.assignment.service;

import dev.radom.constructmanage.app.construction.assignment.model.AssignmentDetailsDto;
import dev.radom.constructmanage.app.construction.assignment.repository.AssignmentMapper;
import dev.radom.constructmanage.app.construction.assignment.model.Assignment;
import dev.radom.constructmanage.app.construction.employee.model.Employee;
import dev.radom.constructmanage.app.construction.assignment.repository.AssignmentRepository;
import dev.radom.constructmanage.app.construction.employee.repository.EmployeeRepository;
import dev.radom.constructmanage.app.construction.assignment.dto.AddNewAssignmentDto;
import dev.radom.constructmanage.app.construction.assignment.model.AssignmentDto;
import dev.radom.constructmanage.app.construction.assignment.dto.UpdateAssignmentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AssigmentServiceImpl implements AssignmentService {
    private final AssignmentRepository assignmentRepository;
    private final EmployeeRepository employeeRepository;
    private final AssignmentMapper assignmentMapper;
    @Override
    public void createNewAssignment(AddNewAssignmentDto addNewAssignmentDto) {
        Employee employee = employeeRepository.findByUuid(addNewAssignmentDto.empUUID())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Employee does not exist!!"));
        Assignment assignment = assignmentMapper.fromAddNewAssignment(addNewAssignmentDto);
        assignment.setUuid(UUID.randomUUID().toString());
        assignment.setDate(LocalDate.now());
        Float chargeHour = employee.getJob().getChargeHour();
        Double charge = (double) (chargeHour * addNewAssignmentDto.hours());
        assignment.setChargeHour(chargeHour);
        assignment.setCharge(charge);
        assignment.setEmployee(employee);
        assignmentRepository.save(assignment);
    }

    @Override
    public void updateAssignmentByUuid(String uuid, UpdateAssignmentDto updateAssignmentDto) {
        Assignment assignment = assignmentRepository.findByUuid(uuid)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Float hours = updateAssignmentDto.hours();
        Float chargeHour = assignment.getEmployee().getJob().getChargeHour();
        Double charge = (double) (chargeHour * hours);
        assignment.setHours(hours);
        assignment.setChargeHour(chargeHour);
        assignment.setCharge(charge);
        assignmentRepository.save(assignment);
    }

    @Override
    public AssignmentDto findAssignmentByUuid(String uuid) {
        Assignment assignment = assignmentRepository.findByUuid(uuid)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return assignmentMapper.toAssignmentDto(assignment);
    }

    @Override
    public List<AssignmentDto> findAllAssignments() {
        return assignmentMapper.toAssignmentDtosList(assignmentRepository.findAll());
    }

    @Override
    public void deleteAssignmentByUuid(String uuid) {
        Assignment assignment = assignmentRepository.findByUuid(uuid)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        assignmentRepository.delete(assignment);
    }
    @Override
    public List<AssignmentDetailsDto> getAllAssignmentsWithDetails() {
        return assignmentMapper.toAssignmentDetailsDtoList(assignmentRepository.findAll());
    }

    @Override
    public AssignmentDetailsDto getAssignmentsWithDetailsByUuid(String uuid) {
        Assignment assignment = assignmentRepository.findByUuid(uuid)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return assignmentMapper.toAssignmentDetailsDto(assignment);
    }
}
