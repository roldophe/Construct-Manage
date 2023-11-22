package dev.radom.constructmanage.api.construction.mapper;

import dev.radom.constructmanage.api.construction.model.Organization;
import dev.radom.constructmanage.api.construction.web.dto.AddNewOrganizationDto;
import dev.radom.constructmanage.api.construction.web.dto.OrganizationDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {
    Organization fromAddNewOrganizationDto(AddNewOrganizationDto addNewOrganizationDto);

    List<OrganizationDto> toOrganizationDtoList(List<Organization> organizations);

    OrganizationDto toOrganizationDto(Organization organization);
}
