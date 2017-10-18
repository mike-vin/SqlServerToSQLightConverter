package com.converter.service;

import com.converter.dto.CityDto;
import com.converter.model.CityEntity;
import com.converter.persistence.repository.CityRepository;
import com.converter.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

import static com.converter.util.Util.toDTOList;
import static com.converter.util.Util.toList;
import static java.util.Objects.nonNull;

@Service
public class CityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public CityDto getById(int id) {
        CityEntity cityEntity = cityRepository.getOne(id);
        return Util.toDTO(cityEntity, CityDto::new);
    }

    public List<CityDto> getAll() {
        return toDTOList(cityRepository.findAll(), null, CityDto::new);
    }

}
