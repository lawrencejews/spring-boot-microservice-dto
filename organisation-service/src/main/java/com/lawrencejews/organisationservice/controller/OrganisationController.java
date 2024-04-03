package com.lawrencejews.organisationservice.controller;

import com.lawrencejews.organisationservice.dto.OrganisationDto;
import com.lawrencejews.organisationservice.service.OrganisationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
       name = "Organisation Service - OrganisationController",
       description = " OrganisationController Exposes REST API for Organisation Service"
)
@RestController
@RequestMapping("api/organisations")
@AllArgsConstructor
public class OrganisationController {

    private OrganisationService organisationService;

    @Operation(
            summary = "Save Organisation REST API",
            description = "Save Organisation REST API is used to the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 CREATED"
    )
    // Build Save Organisation REST API
    @PostMapping
    public ResponseEntity<OrganisationDto> saveOrganisation(@RequestBody OrganisationDto organisationDto){
        OrganisationDto savedOrganisation = organisationService.saveOrganisation(organisationDto);
        return new ResponseEntity<>(savedOrganisation, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Organisation REST API",
            description = "GET Organisation REST API from  the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 SUCCESS"
    )
    // Build Get Organisation REST API
    @GetMapping("{code}")
    public ResponseEntity<OrganisationDto> getOrganisation(@PathVariable("code") String organisationCode){
        OrganisationDto organisationDto = organisationService.getOrganisationByCode(organisationCode);
        return ResponseEntity.ok(organisationDto);
    }
}
