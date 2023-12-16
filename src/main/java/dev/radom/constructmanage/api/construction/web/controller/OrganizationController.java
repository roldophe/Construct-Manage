package dev.radom.constructmanage.api.construction.web.controller;

import dev.radom.constructmanage.api.construction.service.OrganizationService;
import dev.radom.constructmanage.api.construction.web.dto.AddNewOrganizationDto;
import dev.radom.constructmanage.api.construction.web.dto.OrganizationDto;
import dev.radom.constructmanage.api.construction.web.dto.UpdateOrganizationDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/organizations")
public class OrganizationController {
//    private final OrganizationService organizationService;
//
//    @GetMapping
//    public List<OrganizationDto> getAllOrganizations() {
//        return organizationService.findAllOrganization();
//    }
//
//    @PostMapping
//    public void addNewOrganization(@RequestBody @Valid AddNewOrganizationDto addNewOrganizationDto) {
//        organizationService.addNewOrganization(addNewOrganizationDto);
//    }
//
//    @GetMapping("/{code}")
//    public OrganizationDto getOrganizationByCode(@PathVariable String code) {
//        return organizationService.findOrganizationByCode(code);
//    }
//
//    @PutMapping("/{code}")
//    public void updateOrganizationByCode(@PathVariable String code, @RequestBody UpdateOrganizationDto updateOrganizationDto) {
//        organizationService.updateOrganizationByCode(code, updateOrganizationDto);
//    }
//
//    @DeleteMapping("/{code}")
//    public void deleteOrganizationByCode(@PathVariable String code) {
//        organizationService.deleteOrganizationByCode(code);
//    }
}
