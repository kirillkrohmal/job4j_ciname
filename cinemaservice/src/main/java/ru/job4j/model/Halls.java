package ru.job4j.model;

import java.util.Objects;

public class Halls {
    private int id;
    private String rows;
    private String place;

    public Halls() {
    }

    public Halls(int id, String rows, String place) {
        this.id = id;
        this.rows = rows;
        this.place = place;
    }

    public Halls(String rows, String place) {
        this.rows = rows;
        this.place = place;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Halls halls = (Halls) o;
        return Objects.equals(id, halls.id) &&
                Objects.equals(rows, halls.rows) &&
                Objects.equals(place, halls.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rows, place);
    }

    @Override
    public String toString() {
        return "Halls{" +
                "id='" + id + '\'' +
                ", rows='" + rows + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}
