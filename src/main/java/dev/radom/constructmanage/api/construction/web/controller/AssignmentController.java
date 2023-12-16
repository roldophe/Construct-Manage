package dev.radom.constructmanage.api.construction.web.controller;

import dev.radom.constructmanage.api.construction.service.AssignmentService;
import dev.radom.constructmanage.api.construction.web.dto.AddNewAssignmentDto;
import dev.radom.constructmanage.api.construction.web.dto.AssignmentDto;
import dev.radom.constructmanage.api.construction.web.dto.UpdateAssignmentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/assignments")
public class AssignmentController {
//    private final AssignmentService assignmentService;
//
//    @PostMapping
//    public void createNewAssignment(@RequestBody AddNewAssignmentDto addNewAssignmentDto) {
//        assignmentService.createNewAssignment(addNewAssignmentDto);
//    }
//
//    @GetMapping
//    public List<AssignmentDto> getAllAssignments() {
//        return assignmentService.findAllAssignments();
//    }
//
//    @PutMapping("/{uuid}")
//    public void updateAssignmentByUuid(@PathVariable String uuid, @RequestBody UpdateAssignmentDto updateAssignmentDto) {
//        assignmentService.updateAssignmentByUuid(uuid, updateAssignmentDto);
//    }
//
//    @DeleteMapping("/{uuid}")
//    public void deleteAssignmentByUuid(@PathVariable String uuid) {
//        assignmentService.deleteAssignmentByUuid(uuid);
//    }
//
//    @GetMapping("/{uuid}")
//    public AssignmentDto getAssignmentByUuid(@PathVariable String uuid) {
//        return assignmentService.findAssignmentByUuid(uuid);
//    }
}
