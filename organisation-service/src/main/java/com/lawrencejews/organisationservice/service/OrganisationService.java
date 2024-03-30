package com.lawrencejews.organisationservice.service;

import com.lawrencejews.organisationservice.dto.OrganisationDto;
import com.lawrencejews.organisationservice.entity.Organisation;

public interface OrganisationService {
    OrganisationDto saveOrganisation(OrganisationDto organisationDto);

    OrganisationDto getOrganisationByCode(String organisationCode);
}
