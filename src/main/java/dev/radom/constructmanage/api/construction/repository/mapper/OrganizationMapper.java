package dev.radom.constructmanage.api.construction.repository.mapper;

import dev.radom.constructmanage.api.construction.model.Employee;
import dev.radom.constructmanage.api.construction.model.Organization;
import dev.radom.constructmanage.api.construction.web.dto.AddNewOrganizationDto;
import dev.radom.constructmanage.api.construction.web.dto.OrganizationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {
//    OrganizationMapper INSTANCE = Mappers.getMapper(OrganizationMapper.class);
//
//     Organization fromAddNewOrganizationDto(AddNewOrganizationDto addNewOrganizationDto);
//
//    List<OrganizationDto> toOrganizationDtoList(List<Organization> organizations);
//
//    @Mapping(source = "employees", target = "employeeUUIDs", qualifiedByName = "mapEmployee")
//    OrganizationDto toOrganizationDto(Organization organization);
//
//    @Named("mapEmployee")
//    default Set<String> mapEmployee(Set<Employee> employees) {
//        return employees.stream()
//                .map(Employee::getUuid)
//                .collect(Collectors.toSet());
//    }
}