package dev.radom.constructmanage.api.construction.service;

import dev.radom.constructmanage.api.construction.web.dto.InsertNewJobDto;
import dev.radom.constructmanage.api.construction.web.dto.JobDto;
import dev.radom.constructmanage.api.construction.web.dto.UpdateJob;

import java.util.List;

public interface JobService {
    void insertJob(InsertNewJobDto insertNewJobDto);

    void updateJob(String code, UpdateJob updateJob);

    void deleteJobByCode(String code);

    List<JobDto> findAllJobs();

    JobDto findJobByCode(String code);
}
