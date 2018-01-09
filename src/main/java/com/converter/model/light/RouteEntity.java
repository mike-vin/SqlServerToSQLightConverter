package com.converter.model.light;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "route", schema = "main")
public class RouteEntity {
    private int id;
    private String routeId;
    private String nameOfRoute;
    private String numberOfRoute;
    private String cityId;
    private String typeTransportId;
    private String number;

    @Id
    @GeneratedValue
    @Column(name = "_id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "NameOfRoute", nullable = true, length = -1)
    public String getNameOfRoute() {
        return nameOfRoute;
    }

    public void setNameOfRoute(String nameOfRoute) {
        this.nameOfRoute = nameOfRoute;
    }

    @Basic
    @Column(name = "NumberOfRoute", nullable = true, length = -1)
    public String getNumberOfRoute() {
        return numberOfRoute;
    }

    public void setNumberOfRoute(String numberOfRoute) {
        this.numberOfRoute = numberOfRoute;
    }

    @Basic
    @Column(name = "CityID", nullable = true)
    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "TypeTransportID", nullable = true)
    public String getTypeTransportId() {
        return typeTransportId;
    }

    public void setTypeTransportId(String typeTransportId) {
        this.typeTransportId = typeTransportId;
    }

    @Basic
    @Column(name = "Number", nullable = true)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteEntity that = (RouteEntity) o;
        return id == that.id &&
                Objects.equals(routeId, that.routeId) &&
                Objects.equals(nameOfRoute, that.nameOfRoute) &&
                Objects.equals(numberOfRoute, that.numberOfRoute) &&
                Objects.equals(cityId, that.cityId) &&
                Objects.equals(typeTransportId, that.typeTransportId) &&
                Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, routeId, nameOfRoute, numberOfRoute, cityId, typeTransportId, number);
    }
}
