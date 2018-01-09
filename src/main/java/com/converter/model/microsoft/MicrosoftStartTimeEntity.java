package com.converter.model.microsoft;

import com.converter.model.light.LightStartTimeEntity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "StartTime", schema = "dbo")
public class MicrosoftStartTimeEntity {
    private int routeId;
    private int number;
    private int inDepot;
    private int showNumber;
    private int hideNumber;
    private int startTimeId;
    private Time time;
    private String weekend;
    private String winterTable;
    private String underline;

    public MicrosoftStartTimeEntity() {
    }


    @Id
    @Column(name = "StartTimeID")
    public int getStartTimeId() {
        return startTimeId;
    }

    public void setStartTimeId(int startTimeId) {
        this.startTimeId = startTimeId;
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
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
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
        MicrosoftStartTimeEntity that = (MicrosoftStartTimeEntity) o;
        return startTimeId == that.startTimeId &&
                routeId == that.routeId &&
                number == that.number &&
                inDepot == that.inDepot &&
                showNumber == that.showNumber &&
                hideNumber == that.hideNumber &&
                Objects.equals(time, that.time) &&
                Objects.equals(weekend, that.weekend) &&
                Objects.equals(winterTable, that.winterTable) &&
                Objects.equals(underline, that.underline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeId, startTimeId);
    }
}
