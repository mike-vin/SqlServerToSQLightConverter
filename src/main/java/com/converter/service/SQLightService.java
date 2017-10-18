package com.converter.service;

import com.converter.dto.CityDto;
import com.converter.dto.StationDto;
import com.converter.model.CityEntity;
import com.converter.model.StationEntity;
import com.converter.persistence.dao.SqLightCityRepository;
import com.converter.persistence.dao.SqLightStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.converter.util.Util.toDTOList;

@Service
@Transactional(transactionManager = "lightJpaTransactionManager")
public class SQLightService {
    private final SqLightCityRepository sqLightCityRepository;
    private final SqLightStationRepository sqLightStationRepository;

    @Autowired
    public SQLightService(SqLightCityRepository sqLightRepository, SqLightStationRepository sqLightStationRepository) {
        this.sqLightCityRepository = sqLightRepository;
        this.sqLightStationRepository = sqLightStationRepository;
    }

    public int saveAllCities(List<CityEntity> cities) {
        List<CityEntity> saved = sqLightCityRepository.save(cities);
        System.out.println(String.format("cities==saved = %s", cities == saved));
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

    public List<CityDto> getAllCities() {
        return toDTOList(sqLightCityRepository.findAll(), null, CityDto::new);
    }

    public List<StationDto> getAllStations() {
        return toDTOList(sqLightStationRepository.findAll(), null, StationDto::new);
    }
}
