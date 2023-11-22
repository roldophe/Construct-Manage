package dev.radom.constructmanage.api.construction.web;

import dev.radom.constructmanage.api.construction.service.JobService;
import dev.radom.constructmanage.api.construction.web.dto.InsertNewJobDto;
import dev.radom.constructmanage.api.construction.web.dto.JobDto;
import dev.radom.constructmanage.api.construction.web.dto.UpdateJob;
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
    public void insertNewJob(@RequestBody InsertNewJobDto insertNewJobDto) {
        jobService.insertJob(insertNewJobDto);
    }

    @DeleteMapping("/{code}")
    public void deleteJobByCode(@PathVariable String code) {
        jobService.deleteJobByCode(code);
    }

    @PutMapping("/{code}")
    public void updateJobByCode(@PathVariable String code, @RequestBody UpdateJob updateJob) {
        jobService.updateJob(code, updateJob);
    }

}
