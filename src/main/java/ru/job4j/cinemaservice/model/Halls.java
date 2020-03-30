package ru.job4j.cinemaservice.model;

import java.util.Objects;

public class Halls {
    private int id;
    private String rows;
    private String columns;
    private int account_id;

    public Halls() {
    }

    public Halls(int id, String rows, String columns, int account_id) {
        this.id = id;
        this.rows = rows;
        this.columns = columns;
        this.account_id = account_id;
    }

    public Halls(String rows, String columns) {
        this.rows = rows;
        this.columns = columns;
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


    public String getColumns() {
        return columns;
    }

    public void setColumns(String columns) {
        this.columns = columns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Halls halls = (Halls) o;
        return id == halls.id &&
                Objects.equals(rows, halls.rows) &&
                Objects.equals(columns, halls.columns) &&
                Objects.equals(account_id, halls.account_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rows, columns, account_id);
    }
}
