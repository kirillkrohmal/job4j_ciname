package ru.job4j.service;

import ru.job4j.model.Halls;
import ru.job4j.persistence.JdbcStore;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

public class ValidateService {
    private final JdbcStore logic = JdbcStore.getInstance();
    private static final ValidateService INSTANCE = new ValidateService();
    private ConcurrentHashMap<Integer, Halls> storage = new ConcurrentHashMap<>();

    public Collection<Halls> values() {
        return storage.values();
    }

    public static ValidateService getInstance() {
        return INSTANCE;
    }

    public boolean addHalls(String rows, String place) {
        boolean result = false;

        if (rows != null && place != null ) {
            logic.addHolls(new Halls(rows, place));
        }

        return result;
    }
}
