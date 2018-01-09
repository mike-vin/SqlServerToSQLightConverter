package com.converter.dto;

import com.converter.model.light.LightNameOfStationEntity;
import com.converter.model.microsoft.MicrosoftNameOfStationEntity;

import java.sql.Time;
import java.util.Objects;

public class StationDto {
    private long nameOfStationId;
    private long routeId;
    private String name;
    private long numberOfStation;
    private java.sql.Time interval;

    public StationDto() {
    }

    public StationDto(MicrosoftNameOfStationEntity nameOfMicrosoftNameOfStationEntity) {
        this.nameOfStationId = nameOfMicrosoftNameOfStationEntity.getId();
        this.routeId = nameOfMicrosoftNameOfStationEntity.getRouteId();
        this.name = nameOfMicrosoftNameOfStationEntity.getName();
        this.numberOfStation = nameOfMicrosoftNameOfStationEntity.getNumberOfStation();
        this.interval = new Time(nameOfMicrosoftNameOfStationEntity.getInterval().getTime());
    }

    public long getNameOfStationId() {
        return nameOfStationId;
    }

    public void setNameOfStationId(long nameOfStationId) {
        this.nameOfStationId = nameOfStationId;
    }

    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumberOfStation() {
        return numberOfStation;
    }

    public void setNumberOfStation(long numberOfStation) {
        this.numberOfStation = numberOfStation;
    }

    public Time getInterval() {
        return new Time(interval.getTime());
    }

    public void setInterval(Time interval) {
        this.interval = new Time(interval.getTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StationDto that = (StationDto) o;
        return nameOfStationId == that.nameOfStationId &&
                routeId == that.routeId &&
                numberOfStation == that.numberOfStation &&
                Objects.equals(name, that.name) &&
                Objects.equals(interval, that.interval);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfStationId, routeId, name, numberOfStation, interval);
    }

    @Override
    public String toString() {
        return "StationDto{ nameOfStationId = '" + nameOfStationId +
                "', routeId = '" + routeId +
                "', name = '" + name +
                "', numberOfStation = '" + numberOfStation +
                "', interval = '" + interval + "' }";
    }
}
