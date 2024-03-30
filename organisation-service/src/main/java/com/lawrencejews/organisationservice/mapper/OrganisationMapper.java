package com.lawrencejews.organisationservice.mapper;

import com.lawrencejews.organisationservice.dto.OrganisationDto;
import com.lawrencejews.organisationservice.entity.Organisation;

public class OrganisationMapper {

    public static OrganisationDto mapToOrganisationDto(Organisation organisation){
        OrganisationDto organisationDto = new OrganisationDto(
                organisation.getId(),
                organisation.getOrganisationName(),
                organisation.getOrganisationDescription(),
                organisation.getOrganisationCode(),
                organisation.getCreatedDate()
        );

        return organisationDto;
    }

    public static Organisation mapToOrganisation(OrganisationDto organisationDto){
        Organisation organisation = new Organisation(
                organisationDto.getId(),
                organisationDto.getOrganisationName(),
                organisationDto.getOrganisationDescription(),
                organisationDto.getOrganisationCode(),
                organisationDto.getCreatedDate()
        );
        return organisation;
    }
}
