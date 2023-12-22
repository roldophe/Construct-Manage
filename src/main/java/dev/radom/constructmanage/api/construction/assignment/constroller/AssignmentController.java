package dev.radom.constructmanage.api.construction.assignment.constroller;

import dev.radom.constructmanage.api.construction.assignment.model.Assignment;
import dev.radom.constructmanage.api.construction.assignment.model.AssignmentDetailsDto;
import dev.radom.constructmanage.api.construction.assignment.service.AssignmentService;
import dev.radom.constructmanage.api.construction.assignment.dto.AddNewAssignmentDto;
import dev.radom.constructmanage.api.construction.assignment.model.AssignmentDto;
import dev.radom.constructmanage.api.construction.assignment.dto.UpdateAssignmentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/assignments")
public class AssignmentController {
    private final AssignmentService assignmentService;

    @PostMapping
    public void createNewAssignment(@RequestBody AddNewAssignmentDto addNewAssignmentDto) {
        assignmentService.createNewAssignment(addNewAssignmentDto);
    }

    @GetMapping
    public List<AssignmentDto> getAllAssignments() {
        return assignmentService.findAllAssignments();
    }
    @GetMapping("/details")
    public List<AssignmentDetailsDto> getAllAssignmentDetails() {
        return assignmentService.getAllAssignmentsWithDetails();
        //return null;
    }

    @PutMapping("/{uuid}")
    public void updateAssignmentByUuid(@PathVariable String uuid, @RequestBody UpdateAssignmentDto updateAssignmentDto) {
        assignmentService.updateAssignmentByUuid(uuid, updateAssignmentDto);
    }

    @DeleteMapping("/{uuid}")
    public void deleteAssignmentByUuid(@PathVariable String uuid) {
        assignmentService.deleteAssignmentByUuid(uuid);
    }

    @GetMapping("/{uuid}")
    public AssignmentDto getAssignmentByUuid(@PathVariable String uuid) {
        return assignmentService.findAssignmentByUuid(uuid);
    }
    @GetMapping("details/{uuid}")
    public AssignmentDetailsDto getAssignmentsWithDetailsByUuid(@PathVariable String uuid) {
        return assignmentService.getAssignmentsWithDetailsByUuid(uuid);
    }
}
