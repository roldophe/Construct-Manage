package dev.radom.constructmanage.api.construction.service.impl;

import dev.radom.constructmanage.api.construction.service.EmployeeService;

//@Service
//@RequiredArgsConstructor
//@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
//    private final EmployeeRepository employeeRepository;
//    private final EmployeeMapper employeeMapper;
//    private final JobRepository jobRepository;
//
//    @Override
//    public void insertEmployee(AddNewEmployeeDto addNewEmployeeDto) {
//        //log.info("Employee: {}",addEmployeeDto);
//        Boolean existsEmployee = employeeRepository.existsByEmailAndFirstNameAndLastName(addNewEmployeeDto.email(), addNewEmployeeDto.firstName(), addNewEmployeeDto.lastName());
//        Boolean existsEmployeeByEmail = employeeRepository.existsEmployeesByEmail(addNewEmployeeDto.email());
//        if (existsEmployee) throw new ResponseStatusException(HttpStatus.CONFLICT, "Employee already exist!!");
//        if (existsEmployeeByEmail) throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exist!!");
//        Job jobFound = jobRepository.findJobByDescription(addNewEmployeeDto.jobDescription())
//                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Job doest not exist!!"));
//
//        Employee employee = employeeMapper.fromAddEmployeeDto(addNewEmployeeDto);
//        employee.setJob(jobFound);
//        employee.setHireDate(LocalDate.now());
//        employee.setUuid(UUID.randomUUID().toString());
//
//        employeeRepository.save(employee);
//    }
//
//    @Override
//    public void updateEmployeeByUuid(String uuid, UpdateEmployeeDto updateEmployeeDto) {
//        Employee employee = employeeRepository.findByUuid(uuid)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee dost not exist!!"));
//        employeeMapper.fromUpdateEmployeeDto(employee, updateEmployeeDto);
//        employeeRepository.save(employee);
//    }
//
//    @Override
//    public void updateEmployeeAllByUuid(String uuid, AddNewEmployeeDto updateEmployeeDto) {
//
//        Job jobFound = jobRepository.findJobByDescription(updateEmployeeDto.jobDescription())
//                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Job doest not exist!!"));
//        Employee updateEmployee = employeeRepository.findByUuid(uuid)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee dost not exist!!"));
//        updateEmployee.setJob(jobFound);
//        employeeMapper.fromUpdateEmployeeAllInfoDto(updateEmployee,updateEmployeeDto);
//
//        employeeRepository.save(updateEmployee);
//    }
//
//    @Override
//    public List<EmployeeDto> getAllEmployees() {
//        return employeeMapper.toEmployeeDtoList(employeeRepository.findAll());
//    }
//
//
//    @Override
//    public EmployeeDto getEmployeeByUuid(String uuid) {
//        Employee employee = employeeRepository.findByUuid(uuid)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee dost not exist!!"));
//        return employeeMapper.toEmployeeDto(employee);
//    }
//
//    @Override
//    public void deleteEmployeeByUuid(String uuid) {
//        Employee employee = employeeRepository.findByUuid(uuid)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee dost not exist!!"));
//        employeeRepository.delete(employee);
//    }

}
