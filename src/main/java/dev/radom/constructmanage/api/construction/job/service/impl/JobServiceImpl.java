package dev.radom.constructmanage.api.construction.job.service.impl;

import dev.radom.constructmanage.api.construction.job.dto.AddNewJobDto;
import dev.radom.constructmanage.api.construction.job.dto.UpdateJobDto;
import dev.radom.constructmanage.api.construction.job.model.Job;
import dev.radom.constructmanage.api.construction.job.model.JobDto;
import dev.radom.constructmanage.api.construction.job.repository.JobMapper;
import dev.radom.constructmanage.api.construction.job.repository.JobRepository;
import dev.radom.constructmanage.api.construction.job.service.JobService;
import dev.radom.constructmanage.utils.GenerateCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
    private final JobMapper jobMapper;

    @Override
    public void insertJob(AddNewJobDto addNewJobDto) {
        Boolean existsByDesc = jobRepository.existsByDescription(addNewJobDto.description());
        if (existsByDesc) throw new ResponseStatusException(HttpStatus.CONFLICT, "Description already exist!!");
        Job job = jobMapper.fromCreateJobDto(addNewJobDto);
        job.setCode("JOB-" + GenerateCode.generateCode());
        job.setLastUpdate(LocalDateTime.now());
        jobRepository.save(job);
    }

    @Override
    public void updateJob(String code, UpdateJobDto updateJobDto) {
        Job job = jobRepository.findJobByCode(code).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found!!")
        );
        jobMapper.fromUpdateJobDto(job, updateJobDto);
        job.setLastUpdate(LocalDateTime.now());
        jobRepository.save(job);
    }


    @Override
    public void deleteJobByCode(String code) {
        Job job = jobRepository.findJobByCode(code).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found!!")
        );
        jobRepository.delete(job);
    }

    @Override
    public List<JobDto> findAllJobs() {
        return jobMapper.toJobDto(jobRepository.findAll());
    }

    @Override
    public JobDto findJobByCode(String code) {
        Job job = jobRepository.findJobByCode(code).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found!!")
        );
        return jobMapper.toJobDto(job);
    }
}
