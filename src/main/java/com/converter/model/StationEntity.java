package com.converter.model;

import com.converter.dto.StationDto;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "NameOfStation")
public class StationEntity {
    @Id
    @GeneratedValue
    @Column(name = "NameOfStationID")
    private long nameOfStationId;
    @Basic
    @Column(name = "RouteID")
    private long routeId;
    @Basic
    @Column(name = "Name")
    private String name;
    @Basic
    @Column(name = "NumberOfStation")
    private long numberOfStation;
    @Basic
    @Column(name = "Interval")
    private java.sql.Time interval;


    public StationEntity() {
    }

    public StationEntity(StationDto stationDto) {
        this.routeId = stationDto.getRouteId();
        this.name = stationDto.getName();
        this.numberOfStation = stationDto.getNumberOfStation();
        this.interval = new Time(stationDto.getInterval().getTime());
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


    public java.sql.Time getInterval() {
        return new Time(interval.getTime());
    }

    public void setInterval(java.sql.Time interval) {
        this.interval = new Time(interval.getTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StationEntity that = (StationEntity) o;
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
        return this.getClass().getSimpleName() + " { nameOfStationId = '" + nameOfStationId +
                "', routeId = '" + routeId +
                "', name = '" + name +
                "', numberOfStation = '" + numberOfStation +
                "', interval = '" + interval + "' }";
    }
}
