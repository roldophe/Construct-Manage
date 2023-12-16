package dev.radom.constructmanage.api.construction.employee.controller;

import dev.radom.constructmanage.api.construction.employee.dto.AddBankAccountDetailsDto;
import dev.radom.constructmanage.api.construction.employee.dto.AddEmployeeDetailsDto;
import dev.radom.constructmanage.api.construction.employee.dto.AddEmployeeDto;
import dev.radom.constructmanage.api.construction.employee.model.EmployeeDto;
import dev.radom.constructmanage.api.construction.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    @PostMapping
    public void addEmployee(@RequestBody AddEmployeeDto addEmployee){
        employeeService.addEmployee(addEmployee);
    }
    @GetMapping
    public List<EmployeeDto> getAllEmployee(){
        return employeeService.getEmployees();
    }
}
