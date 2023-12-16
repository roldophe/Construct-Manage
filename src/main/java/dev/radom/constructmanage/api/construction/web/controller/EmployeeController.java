package dev.radom.constructmanage.api.construction.web.controller;

import dev.radom.constructmanage.api.construction.service.EmployeeService;
import dev.radom.constructmanage.api.construction.web.dto.AddNewEmployeeDto;
import dev.radom.constructmanage.api.construction.web.dto.EmployeeDto;
import dev.radom.constructmanage.api.construction.web.dto.UpdateEmployeeDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequiredArgsConstructor
//@RequestMapping("api/v1/employees")
//@RestController
public class EmployeeController {
//    private final EmployeeService employeeService;
//
//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<EmployeeDto> employeeDtos() {
//        return employeeService.getAllEmployees();
//    }
//
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public void insertEmployee(@RequestBody @Valid AddNewEmployeeDto addNewEmployeeDto) {
//        employeeService.insertEmployee(addNewEmployeeDto);
//    }
//
//    @GetMapping("/{uuid}")
//    @ResponseStatus(HttpStatus.OK)
//    public EmployeeDto getEmployeeByUuid(@PathVariable String uuid) {
//        return employeeService.getEmployeeByUuid(uuid);
//    }
//
//    @PatchMapping("/{uuid}")
//    @ResponseStatus(HttpStatus.OK)
//    public void updateEmployeeByUuid(@PathVariable String uuid,@RequestBody @Valid UpdateEmployeeDto updateEmployeeDto) {
//        employeeService.updateEmployeeByUuid(uuid, updateEmployeeDto);
//    }
//    @PutMapping("/{uuid}")
//    @ResponseStatus(HttpStatus.OK)
//    public void updateEmployeeByUuid(@PathVariable String uuid,@RequestBody @Valid AddNewEmployeeDto updateEmployeeDto) {
//        employeeService.updateEmployeeAllByUuid(uuid, updateEmployeeDto);
//    }
//    @DeleteMapping("/{uuid}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteEmployeeByUuid(@PathVariable String uuid) {
//        employeeService.deleteEmployeeByUuid(uuid);
//    }

}
