package dev.radom.constructmanage.api.construction.employee.service;

import dev.radom.constructmanage.api.construction.employee.dto.AddBankAccountDetailsDto;
import dev.radom.constructmanage.api.construction.employee.dto.AddEmployeeDto;
import dev.radom.constructmanage.api.construction.employee.repository.mapper.BankAccountDetailsMapper;
import dev.radom.constructmanage.api.construction.employee.repository.mapper.EmployeeDetailsMapper;
import dev.radom.constructmanage.api.construction.employee.repository.mapper.EmployeeMapper;
import dev.radom.constructmanage.api.construction.employee.model.BankAccountDetails;
import dev.radom.constructmanage.api.construction.employee.model.Employee;
import dev.radom.constructmanage.api.construction.employee.model.EmployeeDetails;
import dev.radom.constructmanage.api.construction.employee.model.EmployeeDto;
import dev.radom.constructmanage.api.construction.employee.repository.BankAccountDetailsRepository;
import dev.radom.constructmanage.api.construction.employee.repository.EmployeeDetailsRepository;
import dev.radom.constructmanage.api.construction.employee.repository.EmployeeRepository;
import dev.radom.constructmanage.utils.GenerateCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeDetailsRepository employeeDetailsRepository;
    private final BankAccountDetailsRepository bankAccountDetailsRepository;

    private final EmployeeMapper employeeMapper;
    private final EmployeeDetailsMapper employeeDetailsMapper;
    private final BankAccountDetailsMapper bankAccountDetailsMapper;

    @Override
    @Transactional
    public void addEmployee(AddEmployeeDto addEmployeeDto) {
        Employee employee = employeeMapper.toEntity(addEmployeeDto);
        EmployeeDetails employeeDetails = employeeDetailsMapper.toEntity(addEmployeeDto.employeeDetails());
        Set<AddBankAccountDetailsDto> bankAccountDetailsDtos = addEmployeeDto.employeeDetails().bankAccountDetails();
        Set<BankAccountDetails> bankAccountDetails = bankAccountDetailsMapper.toEntitySet(bankAccountDetailsDtos);
        employee.setEmployeeId("EMP-" + GenerateCode.generateCode());
        employeeDetails.setEmployee(employee);
        // Assign EmployeeDetails to BankAccountDetails
        for (BankAccountDetails account : bankAccountDetails) {
            account.setEmployeeDetails(employeeDetails);
        }
        employeeRepository.save(employee);
        employeeDetailsRepository.save(employeeDetails);
        bankAccountDetailsRepository.saveAll(bankAccountDetails);

//        @Override
//        @Transactional
//        public void addEmployee(AddEmployeeDto addEmployeeDto) {
//            Employee employee = employeeMapper.toEntity(addEmployeeDto);
//            employee.setEmployeeId("EMP-" + GenerateCode.generateCode());
//            employeeRepository.save(employee);
//        }
    }

    @Override
    public List<EmployeeDto> getEmployees() {
        return employeeMapper.toEmployeeDtoList(employeeRepository.findAll());
    }
}