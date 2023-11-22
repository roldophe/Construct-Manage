package dev.radom.constructmanage.api.construction.service;

import dev.radom.constructmanage.api.construction.web.dto.AddNewEmployeeDto;
import dev.radom.constructmanage.api.construction.web.dto.EmployeeDto;
import dev.radom.constructmanage.api.construction.web.dto.UpdateEmployeeDto;

import java.util.List;

public interface EmployeeService {
    void insertEmployee(AddNewEmployeeDto addNewEmployeeDto);
    void updateEmployeeByUuid(String uuid, UpdateEmployeeDto updateEmployeeDto);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto getEmployeeByUuid(String uuid);
    void deleteEmployeeByUuid(String uuid);
}
