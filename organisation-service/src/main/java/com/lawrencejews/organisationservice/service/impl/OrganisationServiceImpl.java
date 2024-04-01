package com.lawrencejews.organisationservice.service.impl;

import com.lawrencejews.organisationservice.dto.OrganisationDto;
import com.lawrencejews.organisationservice.entity.Organisation;
import com.lawrencejews.organisationservice.mapper.OrganisationMapper;
import com.lawrencejews.organisationservice.repository.OrganisationRepository;
import com.lawrencejews.organisationservice.service.OrganisationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganisationServiceImpl implements OrganisationService {

    private OrganisationRepository organisationRepository;
    @Override
    public OrganisationDto saveOrganisation(OrganisationDto organisationDto) {

        // Convert OrganisationDTO into OrganisationJPA
        Organisation organisation = OrganisationMapper.mapToOrganisation(organisationDto);

        Organisation savedOrganisation = organisationRepository.save(organisation);

        return OrganisationMapper.mapToOrganisationDto(savedOrganisation);
    }

    @Override
    public OrganisationDto getOrganisationByCode(String organisationCode) {

        Organisation organisation = organisationRepository.findByOrganisationCode(organisationCode);

        return OrganisationMapper.mapToOrganisationDto(organisation);
    }
}
