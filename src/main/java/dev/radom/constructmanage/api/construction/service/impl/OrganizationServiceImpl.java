package dev.radom.constructmanage.api.construction.service.impl;

import dev.radom.constructmanage.api.construction.mapper.OrganizationMapper;
import dev.radom.constructmanage.api.construction.model.Employee;
import dev.radom.constructmanage.api.construction.model.Organization;
import dev.radom.constructmanage.api.construction.repository.EmployeeRepository;
import dev.radom.constructmanage.api.construction.repository.OrganizationRepository;
import dev.radom.constructmanage.api.construction.service.OrganizationService;
import dev.radom.constructmanage.api.construction.web.dto.AddNewOrganizationDto;
import dev.radom.constructmanage.api.construction.web.dto.OrganizationDto;
import dev.radom.constructmanage.utils.GenerateCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;
    private final EmployeeRepository employeeRepository;

    @Override
    public void addNewOrganization(AddNewOrganizationDto addNewOrganizationDto) {
        boolean existByName = organizationRepository.existsByName(addNewOrganizationDto.name());
        if (existByName) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Name already exists!");
        }

        Organization organization = organizationMapper.INSTANCE.fromAddNewOrganizationDto(addNewOrganizationDto);
        Set<Employee> employees = new HashSet<>();

        addNewOrganizationDto.employeeUUIDs().forEach(empUUId -> {
            Employee employee = employeeRepository.findByUuid(empUUId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            employees.add(employee);
        });

        organization.setCode(GenerateCode.generateCode());
        organization.setEmployees(employees);
        organizationRepository.save(organization);
    }

    @Override
    public void deleteOrganizationByCode(String code) {
        Organization organization = organizationRepository.findOrganizationByCode(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found!!"));
        organizationRepository.delete(organization);
    }

    @Override
    public OrganizationDto findOrganizationByCode(String code) {
        Organization organization = organizationRepository.findOrganizationByCode(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found!!"));

        return organizationMapper.INSTANCE.toOrganizationDto(organization);
    }

    @Override
    public List<OrganizationDto> findAllOrganization() {
        return organizationMapper.toOrganizationDtoList(organizationRepository.findAll());
    }
}
