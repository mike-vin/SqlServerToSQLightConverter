package com.converter.service;

import com.converter.dto.StationDto;
import com.converter.model.CityEntity;
import com.converter.model.StationEntity;
import com.converter.persistence.repository.CityRepository;
import com.converter.persistence.repository.NameOfStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.converter.util.Util.toDTOList;

@Service
public class MicrosoftServerService {
    private final NameOfStationRepository stationRepository;
    private final CityRepository cityRepository;

    @Autowired
    public MicrosoftServerService(CityRepository cityRepository, NameOfStationRepository nameOfStationRepository) {
        this.cityRepository = cityRepository;
        this.stationRepository = nameOfStationRepository;
    }

    public List<StationDto> getAllStationsDTO() {
        return toDTOList(stationRepository.findAll(), null, StationDto::new);
    }

    public List<StationDto> getAllCitiesDTO() {
        return toDTOList(stationRepository.findAll(), null, StationDto::new);
    }

    public List<CityEntity> getAllCityEntities() {
        return cityRepository.findAll();
    }

    public List<StationEntity> getAllStationsEntities() {
        return stationRepository.findAll();
    }
}
