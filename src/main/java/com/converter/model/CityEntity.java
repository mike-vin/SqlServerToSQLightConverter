package com.converter.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "City")
public class CityEntity {

    @Id
    @GeneratedValue
    @Column(name = "CityID")
    private Integer id;

    @Basic
    @Column(name = "Name")
    private String name;

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
        CityEntity that = (CityEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
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
