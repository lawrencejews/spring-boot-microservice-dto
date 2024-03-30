package com.lawrencejews.organisationservice.controller;

import com.lawrencejews.organisationservice.dto.OrganisationDto;
import com.lawrencejews.organisationservice.service.OrganisationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organisations")
@AllArgsConstructor
public class OrganisationController {

    private OrganisationService organisationService;

    // Build Save Organisation REST API
    @PostMapping
    public ResponseEntity<OrganisationDto> saveOrganisation(@RequestBody OrganisationDto organisationDto){
        OrganisationDto savedOrganisation = organisationService.saveOrganisation(organisationDto);
        return new ResponseEntity<>(savedOrganisation, HttpStatus.CREATED);
    }

    // Build Get Organisation REST API
    @GetMapping("{code}")
    public ResponseEntity<OrganisationDto> getOrganisation(@PathVariable("code") String organisationCode){
        OrganisationDto organisationDto = organisationService.getOrganisationByCode(organisationCode);
        return ResponseEntity.ok(organisationDto);
    }
}
