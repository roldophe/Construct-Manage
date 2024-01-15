package dev.radom.constructmanage.app.construction.employee.repository;

import dev.radom.constructmanage.app.construction.employee.model.Employee;
import dev.radom.constructmanage.app.construction.employee.dto.AddNewEmployeeDto;
import dev.radom.constructmanage.app.construction.employee.model.EmployeeDetailsDto;
import dev.radom.constructmanage.app.construction.employee.model.EmployeeDto;
import dev.radom.constructmanage.app.construction.employee.dto.UpdateEmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mapping(source = "jobCode",target = "job.code")
    Employee fromAddEmployeeDto(AddNewEmployeeDto addNewEmployeeDto);
    @Mapping(source = "jobCode",target = "job.code")
    void fromUpdateEmployEDto(@MappingTarget Employee employee, UpdateEmployeeDto updateEmployeeDto);
    List<EmployeeDto> toEmployeeDtoList(List<Employee> employees);
    @Mapping(source = "job.code",target = "jobCode")
    EmployeeDto toEmployeeDto(Employee employee);
    @Mapping(target = "jobDescription",source = "employee.job.description")
    @Mapping(target = "chargeHour",source = "employee.job.chargeHour")
    EmployeeDetailsDto toEmployeeDetailsDtoList(Employee employee);
    List<EmployeeDetailsDto> toEmployeeDetailsDtoList(List<Employee> employees);
}
