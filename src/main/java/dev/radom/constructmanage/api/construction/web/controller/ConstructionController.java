package dev.radom.constructmanage.api.construction.web.controller;

import dev.radom.constructmanage.api.construction.service.ProjectService;
import dev.radom.constructmanage.api.construction.web.dto.ProjectAssignmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/details")
public class ConstructionController {
private final ProjectService projectService;
    @GetMapping("/projects/{uuid}")
    public List<ProjectAssignmentDTO> getProjectsByEmployeeUuid(@PathVariable String uuid) {
        return projectService.getProjectsByEmployeeUuid(uuid);
    }
    @GetMapping("/projects")
    public List<ProjectAssignmentDTO> getProjectsDetails() {
        return projectService.getProjectsDetails();
    }

}
