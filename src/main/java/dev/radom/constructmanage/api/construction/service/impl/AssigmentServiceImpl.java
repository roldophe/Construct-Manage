package dev.radom.constructmanage.api.construction.service.impl;

import dev.radom.constructmanage.api.construction.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssigmentServiceImpl implements AssignmentService {
//    private final AssignmentRepository assignmentRepository;
//    private final EmployeeRepository employeeRepository;
//    private final AssignmentMapper assignmentMapper;
//    @Override
//    public void createNewAssignment(AddNewAssignmentDto addNewAssignmentDto) {
//        Employee employee = employeeRepository.findByUuid(addNewAssignmentDto.empUUID())
//                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Employee does not exist!!"));
//
//        if (assignmentRepository.existsByProjectCodeAndEmployeeId(addNewAssignmentDto.projCode(), employee.getId())) {
//            throw new ResponseStatusException(HttpStatus.CONFLICT, "Assignment already exists for the project and employee!");
//        }
//        Assignment assignment = assignmentMapper.fromAddNewAssignment(addNewAssignmentDto);
//        assignment.setUuid(UUID.randomUUID().toString());
//        assignment.setDate(LocalDate.now());
//        Float chargeHour = employee.getJob().getChargeHour();
//        Double charge = (double) (chargeHour * addNewAssignmentDto.hours());
//        assignment.setChargeHour(chargeHour);
//        assignment.setCharge(charge);
//        assignment.setEmployee(employee);
//        assignmentRepository.save(assignment);
//    }
//
//    @Override
//    public void updateAssignmentByUuid(String uuid, UpdateAssignmentDto updateAssignmentDto) {
//        Assignment assignment = assignmentRepository.findByUuid(uuid)
//                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
//        Float hours = updateAssignmentDto.hours();
//        Float chargeHour = assignment.getEmployee().getJob().getChargeHour();
//        Double charge = (double) (chargeHour * hours);
//        assignment.setHours(hours);
//        assignment.setChargeHour(chargeHour);
//        assignment.setCharge(charge);
//        assignmentRepository.save(assignment);
//    }
//
//    @Override
//    public AssignmentDto findAssignmentByUuid(String uuid) {
//        Assignment assignment = assignmentRepository.findByUuid(uuid)
//                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
//        return assignmentMapper.toAssignmentDto(assignment);
//    }
//
//    @Override
//    public List<AssignmentDto> findAllAssignments() {
//        return assignmentMapper.toAssignmentDtosList(assignmentRepository.findAll());
//    }
//
//    @Override
//    public void deleteAssignmentByUuid(String uuid) {
//        Assignment assignment = assignmentRepository.findByUuid(uuid)
//                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
//        assignmentRepository.delete(assignment);
//    }
//
//    @Override
//    public List<AssignmentDetailsDto> findAllAssignmentDetails() {
//        return assignmentMapper.mapAssignmentToAssignmentDetailsDtoList(assignmentRepository.findAllAssignmentDetail());
//    }
//
//    @Override
//    public AssignmentDetailsDto findAssignmentDetailsByUuid(String uuid) {
//        return null;
//    }
}
