package com.converter.model.LIGHT;

import com.converter.dto.StationDto;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "name_of_station", schema = "main")
public class NameOfStationEntity {
    private Integer id;
    private String nameOfStationId;
    private String routeId;
    private String name;
    private String numberOfStation;
    private String interval;

    public NameOfStationEntity() {
    }

    public NameOfStationEntity(StationDto station) {
        this.nameOfStationId = String.valueOf(station.getNameOfStationId());
        this.routeId = String.valueOf(station.getRouteId());
        this.name = station.getName().trim().replace('\'', '`');
        this.numberOfStation = String.valueOf(station.getNumberOfStation());
        this.interval = String.valueOf(station.getInterval());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "_id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NameOfStationID", nullable = true)
    public String getNameOfStationId() {
        return nameOfStationId;
    }

    public void setNameOfStationId(String nameOfStationId) {
        this.nameOfStationId = nameOfStationId;
    }

    @Basic
    @Column(name = "RouteID", nullable = true)
    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    @Basic
    @Column(name = "Name", nullable = true, length = -1)
    public String getName() {
        return name.trim();
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    @Basic
    @Column(name = "NumberOfStation", nullable = true)
    public String getNumberOfStation() {
        return numberOfStation;
    }

    public void setNumberOfStation(String numberOfStation) {
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
        NameOfStationEntity that = (NameOfStationEntity) o;
        return id == that.id &&
                Objects.equals(nameOfStationId, that.nameOfStationId) &&
                Objects.equals(routeId, that.routeId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(numberOfStation, that.numberOfStation) &&
                Objects.equals(interval, that.interval);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameOfStationId, routeId, name, numberOfStation, interval);
    }
}
