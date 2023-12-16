package dev.radom.constructmanage.api.construction.employee.repository.mapper;

import dev.radom.constructmanage.api.construction.employee.dto.AddEmployeeDto;
import dev.radom.constructmanage.api.construction.employee.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mapping(target = "employeeDetails", ignore = true)
    Employee toEntity(AddEmployeeDto addEmployeeDto);
    //EmployeeDetails toEmployeeDetails(Employee employee);
}
