package dev.radom.constructmanage.api.construction.employee.service;
import dev.radom.constructmanage.api.construction.employee.dto.AddEmployeeDto;
import dev.radom.constructmanage.api.construction.employee.model.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    void addEmployee(AddEmployeeDto addEmployeeDto);
    List<EmployeeDto> getEmployees();
}
