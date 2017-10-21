package com.converter.service;

import com.converter.dto.StationDto;
import com.converter.model.CityEntity;
import com.converter.model.StationEntity;
import com.converter.persistence.microsoft.MicrosoftCityRepository;
import com.converter.persistence.microsoft.MicrosoftStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.converter.util.Util.toDTOList;

@Service
//@Transactional(transactionManager = "jpaTransactionManager")
public class MicrosoftService {
    private final MicrosoftStationRepository microsoftStationRepository;
    private final MicrosoftCityRepository microsoftCityRepository;

    @Autowired
    public MicrosoftService(MicrosoftCityRepository microsoftCityRepository, MicrosoftStationRepository nameOfMicrosoftStationRepository) {
        this.microsoftCityRepository = microsoftCityRepository;
        this.microsoftStationRepository = nameOfMicrosoftStationRepository;
    }

    public List<StationDto> getAllStationsDTO() {
        return toDTOList(microsoftStationRepository.findAll(), null, StationDto::new);
    }

    public List<StationDto> getAllCitiesDTO() {
        return toDTOList(microsoftStationRepository.findAll(), null, StationDto::new);
    }

    public List<CityEntity> getAllCityEntities() {
        return microsoftCityRepository.findAll();
    }

    public List<StationEntity> getAllStationsEntities() {
        return microsoftStationRepository.findAll();
    }
}
