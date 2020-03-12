package ru.job4j.cinemaservice.model;

import java.util.Objects;

public class Accounts {
    private int id;
    private String value;


    public Accounts() {
    }

    public Accounts(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accounts accounts = (Accounts) o;
        return id == accounts.id &&
                Objects.equals(value, accounts.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }
}


