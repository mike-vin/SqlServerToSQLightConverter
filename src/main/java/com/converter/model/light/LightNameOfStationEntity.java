package com.converter.model.light;

import com.converter.model.microsoft.MicrosoftNameOfStationEntity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

import static java.util.Objects.isNull;

@Entity
@Table(name = "name_of_station", schema = "main")
public class LightNameOfStationEntity {
    private long id;
    private long routeId;
    private long numberOfStation;
    private String name;
    private String interval;

    public LightNameOfStationEntity() {
    }

    public LightNameOfStationEntity(MicrosoftNameOfStationEntity station) {
        this.id = station.getId();
        this.id = station.getId();
        this.routeId = station.getRouteId();
        this.name = isNull(station.getName()) ? station.getName() : station.getName().trim().replace('\'', '`');
        this.numberOfStation = station.getNumberOfStation();
        this.interval = String.valueOf(station.getInterval());
    }

    @Id
    @Column(name = "_id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NameOfStationID")
    public long getNameOfStationId() {
        return numberOfStation;
    }

    public void setNameOfStationId(long nameOfStationId) {
        this.numberOfStation = nameOfStationId;
    }

    @Basic
    @Column(name = "RouteID")
    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "NumberOfStation", nullable = true)
    public long getNumberOfStation() {
        return numberOfStation;
    }

    public void setNumberOfStation(long numberOfStation) {
        this.numberOfStation = numberOfStation;
    }

    @Basic
    @Column(name = "Interval", nullable = true)
    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LightNameOfStationEntity that = (LightNameOfStationEntity) o;
        return id == that.id &&
                Objects.equals(routeId, that.routeId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(numberOfStation, that.numberOfStation) &&
                Objects.equals(interval, that.interval);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, routeId);
    }

    @Override
    public String toString() {
        return "LightNameOfStationEntity{" +
                "id=" + id +
                ", routeId=" + routeId +
                ", numberOfStation=" + numberOfStation +
                ", name='" + name + '\'' +
                ", interval='" + interval + '\'' +
                '}';
    }
}
