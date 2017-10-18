package com.converter.dto;

import com.converter.model.CityEntity;

import java.util.Objects;

public class CityDto {
    private Integer id;
    private String name;

    public CityDto() {
    }

    public CityDto(CityEntity cityEntity) {
        this.id = cityEntity.getId();
        this.name = cityEntity.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityDto cityDto = (CityDto) o;
        return Objects.equals(id, cityDto.id) &&
                Objects.equals(name, cityDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "CityDto { id = '" + id + "', name = '" + name + "' }";
    }
}
