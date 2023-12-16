package dev.radom.constructmanage.api.construction.employee.repository.mapper;

import dev.radom.constructmanage.api.construction.employee.dto.AddEmployeeDetailsDto;
import dev.radom.constructmanage.api.construction.employee.model.BankAccountDetails;
import dev.radom.constructmanage.api.construction.employee.model.EmployeeDetails;
import dev.radom.constructmanage.api.construction.employee.model.EmployeeDetailsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeDetailsMapper {
    //@Mapping(ignore = true, target = "bankAccountDetails")
    EmployeeDetails toEntity(AddEmployeeDetailsDto addEmployeeDetailsDto);
    //BankAccountDetails toBankAccountDetails(BankAccountDetails BankAccountDetails);
}