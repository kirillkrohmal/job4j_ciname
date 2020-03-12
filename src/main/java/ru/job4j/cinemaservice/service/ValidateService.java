package ru.job4j.cinemaservice.service;



import ru.job4j.cinemaservice.model.Halls;
import ru.job4j.cinemaservice.persistence.JdbcStore;

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

    public boolean addHalls(String rows, String columns) {
        boolean result = false;

        if (rows != null && columns != null ) {
            logic.addHolls(new Halls(rows, columns));
        }

        return result;
    }
}
