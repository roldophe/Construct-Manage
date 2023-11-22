package dev.radom.constructmanage.api.construction;

import dev.radom.constructmanage.api.construction.model.Employee;
import dev.radom.constructmanage.api.construction.web.dto.AddEmployeeDto;
import dev.radom.constructmanage.api.construction.web.dto.EmployeeDto;
import dev.radom.constructmanage.api.construction.web.dto.UpdateEmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mapping(source = "jobCode",target = "job.code")
    Employee fromAddEmployeeDto(AddEmployeeDto addEmployeeDto);
    void fromUpdateEmployEDto(@MappingTarget Employee employee, UpdateEmployeeDto updateEmployeeDto);
    List<EmployeeDto> toEmployeeDtoList(List<Employee> employees);
    @Mapping(source = "job.code",target = "jobCode")
    EmployeeDto toEmployeeDto(Employee employee);
}
