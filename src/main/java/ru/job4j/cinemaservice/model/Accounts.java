package ru.job4j.cinemaservice.model;

import java.util.Objects;

public class Accounts {
    private int id;
    private String value;
    private String username;
    private int phone;


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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accounts accounts = (Accounts) o;
        return id == accounts.id &&
                phone == accounts.phone &&
                Objects.equals(value, accounts.value) &&
                Objects.equals(username, accounts.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, username, phone);
    }
}


