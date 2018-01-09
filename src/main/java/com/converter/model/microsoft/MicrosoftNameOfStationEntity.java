package com.converter.model.microsoft;

import com.converter.dto.StationDto;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "NameOfStation")
public class MicrosoftNameOfStationEntity {
    @Id
    @Column(name = "NameOfStationID")
    private long id;
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


    public MicrosoftNameOfStationEntity() {
    }

    public MicrosoftNameOfStationEntity(StationDto stationDto) {
        this.routeId = stationDto.getRouteId();
        this.name = stationDto.getName();
        this.numberOfStation = stationDto.getNumberOfStation();
        this.interval = new Time(stationDto.getInterval().getTime());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        MicrosoftNameOfStationEntity that = (MicrosoftNameOfStationEntity) o;
        return id == that.id &&
                routeId == that.routeId &&
                numberOfStation == that.numberOfStation &&
                Objects.equals(name, that.name) &&
                Objects.equals(interval, that.interval);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, routeId);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " { id = '" + id +
                "', routeId = '" + routeId +
                "', name = '" + name +
                "', numberOfStation = '" + numberOfStation +
                "', interval = '" + interval + "' }";
    }
}
