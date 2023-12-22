package dev.radom.constructmanage.api.construction.employee.service;

import dev.radom.constructmanage.api.construction.employee.dto.AddNewEmployeeDto;
import dev.radom.constructmanage.api.construction.employee.model.EmployeeDetailsDto;
import dev.radom.constructmanage.api.construction.employee.model.EmployeeDto;
import dev.radom.constructmanage.api.construction.employee.dto.UpdateEmployeeDto;

import java.util.List;

public interface EmployeeService {
    void insertEmployee(AddNewEmployeeDto addNewEmployeeDto);
    void updateEmployeeByUuid(String uuid, UpdateEmployeeDto updateEmployeeDto);
    List<EmployeeDto> getAllEmployees();
    List<EmployeeDetailsDto> getAllEmployeeDetails();
    EmployeeDto getEmployeeByUuid(String uuid);
    void deleteEmployeeByUuid(String uuid);

}
