package dev.radom.constructmanage.app.construction.employee.service;

import dev.radom.constructmanage.app.construction.employee.model.EmployeeDetailsDto;
import dev.radom.constructmanage.app.construction.employee.repository.EmployeeMapper;
import dev.radom.constructmanage.app.construction.employee.repository.EmployeeRepository;
import dev.radom.constructmanage.app.construction.employee.model.Employee;
import dev.radom.constructmanage.app.construction.employee.dto.AddNewEmployeeDto;
import dev.radom.constructmanage.app.construction.employee.model.EmployeeDto;
import dev.radom.constructmanage.app.construction.employee.dto.UpdateEmployeeDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;


    @Override
    public void insertEmployee(AddNewEmployeeDto addNewEmployeeDto) {
        //log.info("Employee: {}",addEmployeeDto);
        Boolean existsEmployee = employeeRepository.existsByEmailAndFirstNameAndLastName(addNewEmployeeDto.email(), addNewEmployeeDto.firstName(), addNewEmployeeDto.lastName());
        Boolean existsEmployeeByEmail = employeeRepository.existsEmployeesByEmail(addNewEmployeeDto.email());
        if (existsEmployee) throw new ResponseStatusException(HttpStatus.CONFLICT, "Employee already exist!!");
        if (existsEmployeeByEmail) throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exist!!");

        Employee employee = employeeMapper.fromAddEmployeeDto(addNewEmployeeDto);
        employee.setHireDate(LocalDate.now());
        employee.setUuid(UUID.randomUUID().toString());

        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployeeByUuid(String uuid, UpdateEmployeeDto updateEmployeeDto) {
        Employee employee = employeeRepository.findByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee dost not exist!!"));
        employeeMapper.fromUpdateEmployEDto(employee, updateEmployeeDto);
        employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeMapper.toEmployeeDtoList(employeeRepository.findAll());
    }


    @Override
    public EmployeeDto getEmployeeByUuid(String uuid) {
        Employee employee = employeeRepository.findByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee dost not exist!!"));
        return employeeMapper.toEmployeeDto(employee);
    }

    @Override
    public void deleteEmployeeByUuid(String uuid) {
        Employee employee = employeeRepository.findByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee dost not exist!!"));
        employeeRepository.delete(employee);
    }

    @Override
    public List<EmployeeDetailsDto> getAllEmployeeDetails() {
        return employeeMapper.toEmployeeDetailsDtoList(employeeRepository.findAll());
    }
}
