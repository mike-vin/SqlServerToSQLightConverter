package com.converter.service;

import com.converter.dto.StationDto;
import com.converter.persistence.repository.NameOfStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.converter.util.Util.toDTOList;

@Service
public class NameOfStationService {
    private final NameOfStationRepository nameOfStationRepository;

    @Autowired
    public NameOfStationService(NameOfStationRepository nameOfStationRepository) {
        this.nameOfStationRepository = nameOfStationRepository;
    }

    public List<StationDto> getAll() {
        return toDTOList(nameOfStationRepository.findAll(), null, StationDto::new);
    }
}
