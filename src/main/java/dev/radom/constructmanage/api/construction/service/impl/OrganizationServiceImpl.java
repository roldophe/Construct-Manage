package dev.radom.constructmanage.api.construction.service.impl;

import dev.radom.constructmanage.api.construction.mapper.OrganizationMapper;
import dev.radom.constructmanage.api.construction.model.Organization;
import dev.radom.constructmanage.api.construction.repository.OrganizationRepository;
import dev.radom.constructmanage.api.construction.service.OrganizationService;
import dev.radom.constructmanage.api.construction.web.dto.AddNewOrganizationDto;
import dev.radom.constructmanage.api.construction.web.dto.OrganizationDto;
import dev.radom.constructmanage.utils.GenerateCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;

    @Override
    public void addNewOrganization(AddNewOrganizationDto addNewOrganizationDto) {
        Boolean existByName = organizationRepository.existsByName(addNewOrganizationDto.name());
        if (existByName) throw new ResponseStatusException(HttpStatus.CONFLICT, "Name already exist!!");
        Organization organization = organizationMapper.fromAddNewOrganizationDto(addNewOrganizationDto);
        organization.setCode(GenerateCode.generateCode());
        organizationRepository.save(organization);
    }

    @Override
    public void deleteOrganizationByCode(String code) {
        Organization organization = organizationRepository.findByCode(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found!!"));
        organizationRepository.delete(organization);
    }

    @Override
    public OrganizationDto findOrganizationByCode(String code) {
        Organization organization = organizationRepository.findByCode(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found!!"));
        return organizationMapper.toOrganizationDto(organization);
    }

    @Override
    public List<OrganizationDto> findAllOrganization() {
        return organizationMapper.toOrganizationDtoList(organizationRepository.findAll());
    }
}
