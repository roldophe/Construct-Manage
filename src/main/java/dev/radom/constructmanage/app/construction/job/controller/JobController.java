package dev.radom.constructmanage.app.construction.job.controller;

import dev.radom.constructmanage.app.construction.job.service.JobService;
import dev.radom.constructmanage.app.construction.job.dto.AddNewJobDto;
import dev.radom.constructmanage.app.construction.job.model.JobDto;
import dev.radom.constructmanage.app.construction.job.dto.UpdateJobDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/v1/jobs")
@RestController
public class JobController {
    private final JobService jobService;

    @GetMapping
    public List<JobDto> getAllJob() {
        return jobService.findAllJobs();
    }

    @GetMapping("/{code}")
    public JobDto findJobByCode(@PathVariable String code) {
        return jobService.findJobByCode(code);
    }

    @PostMapping()
    public void insertNewJob(@RequestBody @Valid AddNewJobDto addNewJobDto) {
        jobService.insertJob(addNewJobDto);
    }

    @DeleteMapping("/{code}")
    public void deleteJobByCode(@PathVariable String code) {
        jobService.deleteJobByCode(code);
    }

    @PutMapping("/{code}")
    public void updateJobByCode(@PathVariable String code, @RequestBody @Valid UpdateJobDto updateJobDto) {
        jobService.updateJob(code, updateJobDto);
    }

}
