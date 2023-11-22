package dev.radom.constructmanage.api.construction;

import dev.radom.constructmanage.api.construction.model.Job;
import dev.radom.constructmanage.api.construction.web.dto.InsertNewJobDto;
import dev.radom.constructmanage.api.construction.web.dto.JobDto;
import dev.radom.constructmanage.api.construction.web.dto.UpdateJob;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JobMapper {
    Job fromCreateJobDto(InsertNewJobDto insertNewJobDto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromUpdateJobDto(@MappingTarget Job job, UpdateJob updateJob);
    JobDto toJobDto(Job job);
    List<JobDto> toJobDto(List<Job> jobs);
}
