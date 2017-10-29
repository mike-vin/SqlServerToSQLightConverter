package com.converter.service;

import com.converter.dto.CityDto;
import com.converter.dto.StationDto;
import com.converter.model.CityEntity;
import com.converter.model.LIGHT.NameOfStationEntity;
import com.converter.model.StationEntity;
import com.converter.persistence.light.LightCityRepository;
import com.converter.persistence.light.LightNameOfStationRepository;
import com.converter.persistence.light.LightStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.converter.util.Util.toDTOList;

@Service
@Transactional(transactionManager = "lightJpaTransactionManager"/*, isolation = Isolation.READ_UNCOMMITTED*/)
public class LightService {
    private final LightCityRepository lightCityRepository;
    private final LightStationRepository sqLightStationRepository;
    private final LightNameOfStationRepository nameOfStationRepository;

    @Autowired
    public LightService(LightCityRepository sqLightRepository, LightStationRepository sqLightStationRepository, LightNameOfStationRepository nameOfStationRepository) {
        this.lightCityRepository = sqLightRepository;
        this.sqLightStationRepository = sqLightStationRepository;
        this.nameOfStationRepository = nameOfStationRepository;
    }

    public List<CityDto> saveAllCities(List<CityEntity> cities) {
        List<CityEntity> saved = lightCityRepository.save(cities);
        return toDTOList(saved, CityDto::new);
    }

    public List<CityDto> saveAllCitiesByDTO(List<CityDto> cities) {
        List<CityEntity> cityEntities = toDTOList(cities, null, CityEntity::new);
        List<CityEntity> saved = lightCityRepository.save(cityEntities);
        return toDTOList(saved, CityDto::new);
    }

    public List<StationDto> saveStationsByDTO(List<StationDto> cities) {
        List<NameOfStationEntity> names = toDTOList(cities, null, NameOfStationEntity::new);
        List<NameOfStationEntity> saved = nameOfStationRepository.save(names);
        return toDTOList(saved, StationDto::new);
    }

    public List<StationDto> saveAllStations(List<StationEntity> stations) {

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~< SAVING >~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        List<StationEntity> saved = sqLightStationRepository.save(stations);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~< SAVED >~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        return toDTOList(saved, StationDto::new);
    }

    public List<StationDto> saveAllStationsByDTO(List<StationDto> stations) {
        List<StationEntity> stationEntityList = toDTOList(stations, StationEntity::new);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~< SAVING >~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        List<StationEntity> saved = sqLightStationRepository.save(stationEntityList);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~< SAVED >~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        return toDTOList(saved, StationDto::new);
    }

    public List<CityEntity> getAllCitiesEntity() {
        return lightCityRepository.findAll();
    }

    public List<StationEntity> getAllStationsEntity() {
        return sqLightStationRepository.findAll();
    }

    public List<CityDto> getAllCities() {
        return toDTOList(lightCityRepository.findAll(), null, CityDto::new);
    }

    public List<StationDto> getAllStations() {
        return toDTOList(sqLightStationRepository.findAll(), null, StationDto::new);
    }
}
