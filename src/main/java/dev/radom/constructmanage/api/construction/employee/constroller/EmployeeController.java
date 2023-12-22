package dev.radom.constructmanage.api.construction.employee.constroller;

import dev.radom.constructmanage.api.construction.employee.model.EmployeeDetailsDto;
import dev.radom.constructmanage.api.construction.employee.service.EmployeeService;
import dev.radom.constructmanage.api.construction.employee.dto.AddNewEmployeeDto;
import dev.radom.constructmanage.api.construction.employee.model.EmployeeDto;
import dev.radom.constructmanage.api.construction.employee.dto.UpdateEmployeeDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/v1/employees")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/details")
    public List<EmployeeDetailsDto> getAllEmployeeDetails() {
        return employeeService.getAllEmployeeDetails();
    }

    @PostMapping
    public void insertEmployee(@RequestBody @Valid AddNewEmployeeDto addNewEmployeeDto) {
        employeeService.insertEmployee(addNewEmployeeDto);
    }

    @GetMapping("/{uuid}")
    public EmployeeDto getEmployeeByUuid(@PathVariable String uuid) {
        return employeeService.getEmployeeByUuid(uuid);
    }

    @PatchMapping("/{uuid}")
    public void updateEmployeeByUuid(@PathVariable String uuid,@RequestBody @Valid UpdateEmployeeDto updateEmployeeDto) {
        employeeService.updateEmployeeByUuid(uuid, updateEmployeeDto);
    }

    @DeleteMapping("/{uuid}")
    public void deleteEmployeeByUuid(@PathVariable String uuid) {
        employeeService.deleteEmployeeByUuid(uuid);
    }

}
