package com.converter.service;

import com.converter.dto.CityDto;
import com.converter.dto.StationDto;
import com.converter.model.CityEntity;
import com.converter.model.StationEntity;
import com.converter.persistence.light.LightCityRepository;
import com.converter.persistence.light.LightStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.converter.util.Util.toDTOList;

@Service
//@Transactional(transactionManager = "lightJpaTransactionManager")
public class LightService {
    private final LightCityRepository lightCityRepository;
    private final LightStationRepository sqLightStationRepository;

    @Autowired
    public LightService(LightCityRepository sqLightRepository, LightStationRepository sqLightStationRepository) {
        this.lightCityRepository = sqLightRepository;
        this.sqLightStationRepository = sqLightStationRepository;
    }

    public int saveAllCities(List<CityEntity> cities) {
        List<CityEntity> saved = lightCityRepository.save(cities);
        System.out.println(lightCityRepository.count());
        System.out.println(String.format("cities==saved = %s", cities.size() == saved.size()));
        return saved.size();
    }

    public int saveAllStations(List<StationEntity> stations) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~< SAVING >~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        List<StationEntity> saved = sqLightStationRepository.save(stations);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~< SAVED >~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        return saved.size();
    }

    public int saveAllStationsByDTO(List<StationDto> stations) {
        List<StationEntity> stationEntityList = toDTOList(stations, null, StationEntity::new);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~< SAVING >~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        List<StationEntity> saved = sqLightStationRepository.save(stationEntityList);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~< SAVED >~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        return saved.size();
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
