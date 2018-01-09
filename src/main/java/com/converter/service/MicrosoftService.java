package com.converter.service;

import com.converter.model.microsoft.MicrosoftNameOfStationEntity;
import com.converter.model.microsoft.MicrosoftStartTimeEntity;
import com.converter.persistence.microsoft.MicrosoftNameOfStationRepository;
import com.converter.persistence.microsoft.MicrosoftStartTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(transactionManager = "microsoftTransactionManager", readOnly = true)
public class MicrosoftService {
    private final MicrosoftNameOfStationRepository stationRepository;
    private final MicrosoftStartTimeRepository startTimeRepository;

    @Autowired
    public MicrosoftService(MicrosoftNameOfStationRepository nameOfMicrosoftStationRepository,
                            MicrosoftStartTimeRepository startTimeRepository) {
        this.stationRepository = nameOfMicrosoftStationRepository;
        this.startTimeRepository = startTimeRepository;
    }

    public List<MicrosoftNameOfStationEntity> getAllStations() {
        return stationRepository.findAll();
    }

    public List<MicrosoftStartTimeEntity> getAllStartTime() {
        return startTimeRepository.findAll();
    }
}