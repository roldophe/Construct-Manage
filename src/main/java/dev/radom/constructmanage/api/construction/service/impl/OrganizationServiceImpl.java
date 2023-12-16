package dev.radom.constructmanage.api.construction.service.impl;

import dev.radom.constructmanage.api.construction.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrganizationServiceImpl implements OrganizationService {
//    private final OrganizationRepository organizationRepository;
//    private final OrganizationMapper organizationMapper;
//    private final EmployeeRepository employeeRepository;
//
//    @Override
//    public void addNewOrganization(AddNewOrganizationDto addNewOrganizationDto) {
//        boolean existByName = organizationRepository.existsByName(addNewOrganizationDto.name());
//        if (existByName) {
//            throw new ResponseStatusException(HttpStatus.CONFLICT, "Name already exists!");
//        }
//
//        Organization organization = organizationMapper.INSTANCE.fromAddNewOrganizationDto(addNewOrganizationDto);
//        Set<Employee> employees = new HashSet<>();
//
//        addNewOrganizationDto.employeeUUIDs().forEach(empUUId -> {
//            Employee employee = employeeRepository.findByUuid(empUUId)
//                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//            employees.add(employee);
//        });
//
//        organization.setCode(GenerateCode.generateCode());
//        organization.setEmployees(employees);
//        organizationRepository.save(organization);
//    }
//
//    @Override
//    public void deleteOrganizationByCode(String code) {
//        Organization organization = organizationRepository.findOrganizationByCode(code)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found!!"));
//        organizationRepository.delete(organization);
//    }
//
//    @Override
//    public void updateOrganizationByCode(String code, UpdateOrganizationDto updateOrganizationDto) {
//        Organization organization = organizationRepository.findOrganizationByCode(code)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found!!"));
//        Set<Employee> employees = new HashSet<>();
//        updateOrganizationDto.employeeUUIDs().forEach(empUUID -> {
//            Employee employee = employeeRepository.findByUuid(empUUID)
//                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//            employees.add(employee);
//        });
//        organization.setEmployees(employees);
//        organizationRepository.save(organization);
//    }
//
//    @Override
//    public OrganizationDto findOrganizationByCode(String code) {
//        Organization organization = organizationRepository.findOrganizationByCode(code)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found!!"));
//        return organizationMapper.INSTANCE.toOrganizationDto(organization);
//    }
//
//    @Override
//    public List<OrganizationDto> findAllOrganization() {
//        return organizationMapper.toOrganizationDtoList(organizationRepository.findAll());
//    }
}
