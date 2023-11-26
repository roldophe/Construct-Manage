package dev.radom.constructmanage.api.construction.service;

import dev.radom.constructmanage.api.construction.web.dto.AddNewOrganizationDto;
import dev.radom.constructmanage.api.construction.web.dto.OrganizationDto;

import java.util.List ;

public interface OrganizationService {
    void addNewOrganization(AddNewOrganizationDto addNewOrganizationDto);

    void deleteOrganizationByCode(String code);

    OrganizationDto findOrganizationByCode(String code);

    List<OrganizationDto> findAllOrganization();
}
