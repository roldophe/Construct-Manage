package dev.radom.constructmanage.app.construction.job.repository;

import dev.radom.constructmanage.app.construction.job.model.Job;
import dev.radom.constructmanage.app.construction.job.dto.AddNewJobDto;
import dev.radom.constructmanage.app.construction.job.model.JobDto;
import dev.radom.constructmanage.app.construction.job.dto.UpdateJobDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JobMapper {
    Job fromCreateJobDto(AddNewJobDto addNewJobDto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromUpdateJobDto(@MappingTarget Job job, UpdateJobDto updateJobDto);
    JobDto toJobDto(Job job);
    List<JobDto> toJobDto(List<Job> jobs);
}
