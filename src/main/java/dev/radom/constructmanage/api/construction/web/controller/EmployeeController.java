package dev.radom.constructmanage.api.construction.web.controller;

import dev.radom.constructmanage.api.construction.service.EmployeeService;
import dev.radom.constructmanage.api.construction.web.dto.AddNewEmployeeDto;
import dev.radom.constructmanage.api.construction.web.dto.EmployeeDto;
import dev.radom.constructmanage.api.construction.web.dto.UpdateEmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/v1/employees")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDto> employeeDtos() {
        return employeeService.getAllEmployees();
    }


    @PostMapping
    public void insertEmployee(@RequestBody AddNewEmployeeDto addNewEmployeeDto) {
        employeeService.insertEmployee(addNewEmployeeDto);
    }

    @GetMapping("/{uuid}")
    public EmployeeDto getEmployeeByUuid(@PathVariable String uuid) {
        return employeeService.getEmployeeByUuid(uuid);
    }

    @PatchMapping("/{uuid}")
    public void updateEmployeeByUuid(@PathVariable String uuid, UpdateEmployeeDto updateEmployeeDto) {
        employeeService.updateEmployeeByUuid(uuid, updateEmployeeDto);
    }

    @DeleteMapping("/{uuid}")
    public void deleteEmployeeByUuid(@PathVariable String uuid) {
        employeeService.deleteEmployeeByUuid(uuid);
    }

}
