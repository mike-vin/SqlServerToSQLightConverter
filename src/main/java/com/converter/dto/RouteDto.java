package com.converter.dto;

import java.util.Objects;

public class RouteDto {
    private int id;
    private String routeId;
    private String nameOfRoute;
    private String numberOfRoute;
    private String cityId;
    private String typeTransportId;
    private String number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getNameOfRoute() {
        return nameOfRoute;
    }

    public void setNameOfRoute(String nameOfRoute) {
        this.nameOfRoute = nameOfRoute;
    }

    public String getNumberOfRoute() {
        return numberOfRoute;
    }

    public void setNumberOfRoute(String numberOfRoute) {
        this.numberOfRoute = numberOfRoute;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getTypeTransportId() {
        return typeTransportId;
    }

    public void setTypeTransportId(String typeTransportId) {
        this.typeTransportId = typeTransportId;
    }

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
        RouteDto routeDto = (RouteDto) o;
        return id == routeDto.id &&
                Objects.equals(routeId, routeDto.routeId) &&
                Objects.equals(nameOfRoute, routeDto.nameOfRoute) &&
                Objects.equals(numberOfRoute, routeDto.numberOfRoute) &&
                Objects.equals(cityId, routeDto.cityId) &&
                Objects.equals(typeTransportId, routeDto.typeTransportId) &&
                Objects.equals(number, routeDto.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, routeId);
    }

    @Override
    public String toString() {
        return "RouteDto{" +
                "id=" + id +
                ", routeId='" + routeId + '\'' +
                ", nameOfRoute='" + nameOfRoute + '\'' +
                ", numberOfRoute='" + numberOfRoute + '\'' +
                ", cityId='" + cityId + '\'' +
                ", typeTransportId='" + typeTransportId + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
