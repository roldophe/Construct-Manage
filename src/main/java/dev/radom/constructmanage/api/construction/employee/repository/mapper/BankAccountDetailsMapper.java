package dev.radom.constructmanage.api.construction.employee.repository.mapper;

import dev.radom.constructmanage.api.construction.employee.dto.AddBankAccountDetailsDto;
import dev.radom.constructmanage.api.construction.employee.model.BankAccountDetails;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface BankAccountDetailsMapper {
    BankAccountDetails toEntity(AddBankAccountDetailsDto addBankAccountDetailsDto);

    Set<BankAccountDetails> toEntitySet(Set<AddBankAccountDetailsDto> bankAccountDetailsDtos);
}