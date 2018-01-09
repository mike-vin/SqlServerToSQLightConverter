package com.converter.model.light;

import com.converter.model.microsoft.MicrosoftStartTimeEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "start_time", schema = "main")
public class LightStartTimeEntity {
    private int id;
    private int routeId;
    private int number;
    private int inDepot;
    private int showNumber;
    private int hideNumber;
    private int startTimeId;
    private String time;
    private String weekend;
    private String winterTable;
    private String underline;

    public LightStartTimeEntity() {
    }

    public LightStartTimeEntity(MicrosoftStartTimeEntity microsoftStartTimeEntity) {
        this.startTimeId = microsoftStartTimeEntity.getStartTimeId();
        this.routeId = microsoftStartTimeEntity.getRouteId();
        this.number = microsoftStartTimeEntity.getNumber();
        this.inDepot = microsoftStartTimeEntity.getInDepot();
        this.showNumber = microsoftStartTimeEntity.getShowNumber();
        this.hideNumber = microsoftStartTimeEntity.getHideNumber();
        this.time = microsoftStartTimeEntity.getTime().toString();
        this.weekend = microsoftStartTimeEntity.getWeekend();
        this.winterTable = microsoftStartTimeEntity.getWinterTable();
        this.underline = microsoftStartTimeEntity.getUnderline();
    }

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
    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    @Basic
    @Column(name = "Time", nullable = true)
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "Weekend", nullable = true)
    public String getWeekend() {
        return weekend;
    }

    public void setWeekend(String weekend) {
        this.weekend = weekend;
    }

    @Basic
    @Column(name = "Number", nullable = true)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "WinterTable", nullable = true)
    public String getWinterTable() {
        return winterTable;
    }

    public void setWinterTable(String winterTable) {
        this.winterTable = winterTable;
    }

    @Basic
    @Column(name = "InDepot", nullable = true)
    public int getInDepot() {
        return inDepot;
    }

    public void setInDepot(int inDepot) {
        this.inDepot = inDepot;
    }

    @Basic
    @Column(name = "ShowNumber", nullable = true)
    public int getShowNumber() {
        return showNumber;
    }

    public void setShowNumber(int showNumber) {
        this.showNumber = showNumber;
    }

    @Basic
    @Column(name = "HideNumber", nullable = true)
    public int getHideNumber() {
        return hideNumber;
    }

    public void setHideNumber(int hideNumber) {
        this.hideNumber = hideNumber;
    }

    @Basic
    @Column(name = "StartTimeID", nullable = true)
    public int getStartTimeId() {
        return startTimeId;
    }

    public void setStartTimeId(int startTimeId) {
        this.startTimeId = startTimeId;
    }

    @Basic
    @Column(name = "Underline", nullable = true)
    public String getUnderline() {
        return underline;
    }

    public void setUnderline(String underline) {
        this.underline = underline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LightStartTimeEntity that = (LightStartTimeEntity) o;
        return id == that.id &&
                routeId == that.routeId &&
                number == that.number &&
                inDepot == that.inDepot &&
                showNumber == that.showNumber &&
                hideNumber == that.hideNumber &&
                startTimeId == that.startTimeId &&
                Objects.equals(time, that.time) &&
                Objects.equals(weekend, that.weekend) &&
                Objects.equals(winterTable, that.winterTable) &&
                Objects.equals(underline, that.underline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, routeId, startTimeId);
    }

    @Override
    public String toString() {
        return "LightStartTimeEntity{" +
                "id=" + id +
                ", routeId=" + routeId +
                ", number=" + number +
                ", inDepot=" + inDepot +
                ", showNumber=" + showNumber +
                ", hideNumber=" + hideNumber +
                ", startTimeId=" + startTimeId +
                ", time='" + time + '\'' +
                ", weekend='" + weekend + '\'' +
                ", winterTable='" + winterTable + '\'' +
                ", underline='" + underline + '\'' +
                '}';
    }
}
