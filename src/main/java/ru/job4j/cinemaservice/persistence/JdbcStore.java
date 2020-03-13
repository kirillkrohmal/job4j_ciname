package ru.job4j.cinemaservice.persistence;



import ru.job4j.cinemaservice.model.Accounts;
import ru.job4j.cinemaservice.model.Halls;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcStore {
    private static final JdbcStore INSTANCE = new JdbcStore();
    private Connection connection;


    public static JdbcStore getInstance() {
        return INSTANCE;
    }


    public Halls addHolls(Halls halls) {
        String s1 = "INSERT INTO halls(rows, columns) VALUES (?, ?)";

        try(Connection connection = init()) {
            PreparedStatement statement = connection.prepareStatement(s1);
            statement.setString(1, halls.getRows());
            statement.setString(2, halls.getColumns());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return halls;
    }

    public Accounts addAccounts(Accounts accounts) {
        String s1 = "INSERT INTO accounts(getValue, username, phone) VALUES (?, ?, ?)";

        try(Connection connection = init()) {
            PreparedStatement statement = connection.prepareStatement(s1);
            statement.setString(1, accounts.getValue());
            statement.setString(2, accounts.getUsername());
            statement.setString(3, accounts.getPhone());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    public Connection init() throws SQLException {
        Properties config = new Properties();

        try (InputStream in = JdbcStore.class.getClassLoader().getResourceAsStream("app.properties")) {
            config.load(in);
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }

        String url = config.getProperty("url");
        String username = config.getProperty("username");
        String password = config.getProperty("password");

        this.connection = DriverManager.getConnection(url, username, password);

        return connection;
    }
}
