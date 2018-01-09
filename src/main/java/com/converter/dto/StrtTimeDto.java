package com.converter.dto;

import java.util.Objects;

public class StrtTimeDto {
    private int id;
    private int routeId;
    private String time;
    private String weekend;
    private int number;
    private String winterTable;
    private int inDepot;
    private int showNumber;
    private int hideNumber;
    private int startTimeId;
    private String underline;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWeekend() {
        return weekend;
    }

    public void setWeekend(String weekend) {
        this.weekend = weekend;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getWinterTable() {
        return winterTable;
    }

    public void setWinterTable(String winterTable) {
        this.winterTable = winterTable;
    }

    public int getInDepot() {
        return inDepot;
    }

    public void setInDepot(int inDepot) {
        this.inDepot = inDepot;
    }

    public int getShowNumber() {
        return showNumber;
    }

    public void setShowNumber(int showNumber) {
        this.showNumber = showNumber;
    }

    public int getHideNumber() {
        return hideNumber;
    }

    public void setHideNumber(int hideNumber) {
        this.hideNumber = hideNumber;
    }

    public int getStartTimeId() {
        return startTimeId;
    }

    public void setStartTimeId(int startTimeId) {
        this.startTimeId = startTimeId;
    }

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
        StrtTimeDto that = (StrtTimeDto) o;
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
        return "StrtTimeDto{" +
                "id=" + id +
                ", routeId=" + routeId +
                ", time='" + time + '\'' +
                ", weekend='" + weekend + '\'' +
                ", number=" + number +
                ", winterTable='" + winterTable + '\'' +
                ", inDepot=" + inDepot +
                ", showNumber=" + showNumber +
                ", hideNumber=" + hideNumber +
                ", startTimeId=" + startTimeId +
                ", underline='" + underline + '\'' +
                '}';
    }
}
