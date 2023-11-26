package dev.radom.constructmanage.api.construction.web.controller;

import dev.radom.constructmanage.api.construction.service.ProjectService;
import dev.radom.constructmanage.api.construction.web.dto.AddNewProjectDto;
import dev.radom.constructmanage.api.construction.web.dto.ProjectDto;
import dev.radom.constructmanage.api.construction.web.dto.UpdateProjectDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/v1/projects")
@RestController
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping
    public List<ProjectDto> getAllJob() {
        return projectService.findAllProjects();
    }

    @GetMapping("/{projCode}")
    public ProjectDto findProjectByCode(@PathVariable String projCode) {
        return projectService.findProjectByCode(projCode);
    }

    @PostMapping()
    public void insertNewProject(@RequestBody @Valid AddNewProjectDto addNewProjectDto) {
        projectService.insertProject(addNewProjectDto);
    }

    @DeleteMapping("/{projCode}")
    public void deleteJobByCode(@PathVariable String projCode) {
        projectService.deleteProjectByCode(projCode);
    }

    @PutMapping("/{projCode}")
    public void updateJobByCode(@PathVariable String projCode, @RequestBody @Valid UpdateProjectDto updateNewProject) {
        projectService.updateProjectByCode(projCode, updateNewProject);
    }
}
