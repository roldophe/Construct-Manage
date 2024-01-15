package dev.radom.constructmanage.app.construction.job.service;

import dev.radom.constructmanage.app.construction.job.dto.AddNewJobDto;
import dev.radom.constructmanage.app.construction.job.dto.UpdateJobDto;
import dev.radom.constructmanage.app.construction.job.model.JobDto;

import java.util.List;

public interface JobService {
    void insertJob(AddNewJobDto addNewJobDto);

    void updateJob(String code, UpdateJobDto updateJobDto);


    void deleteJobByCode(String code);

    List<JobDto> findAllJobs();

    JobDto findJobByCode(String code);
}
