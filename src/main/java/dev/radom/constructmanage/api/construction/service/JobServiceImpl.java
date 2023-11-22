package dev.radom.constructmanage.api.construction.service;

import dev.radom.constructmanage.api.construction.model.Job;
import dev.radom.constructmanage.api.construction.JobMapper;
import dev.radom.constructmanage.api.construction.JobRepository;
import dev.radom.constructmanage.api.construction.web.dto.InsertNewJobDto;
import dev.radom.constructmanage.api.construction.web.dto.JobDto;
import dev.radom.constructmanage.api.construction.web.dto.UpdateJob;
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
    public void insertJob(InsertNewJobDto insertNewJobDto) {
        Boolean existsByDesc = jobRepository.existsByDescription(insertNewJobDto.description());
        if (existsByDesc) throw new ResponseStatusException(HttpStatus.CONFLICT, "Description already exist!!");
        Job job = jobMapper.fromCreateJobDto(insertNewJobDto);
        job.setCode("JOB-" + GenerateCode.generateCode());
        job.setLastUpdate(LocalDateTime.now());
        jobRepository.save(job);
    }

    @Override
    public void updateJob(String code, UpdateJob updateJob) {
        Job job = jobRepository.findJobByCode(code).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found!!")
        );
        jobMapper.fromUpdateJobDto(job, updateJob);
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
