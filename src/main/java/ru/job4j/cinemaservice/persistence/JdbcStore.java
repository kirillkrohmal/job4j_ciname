package ru.job4j.cinemaservice.persistence;



import ru.job4j.cinemaservice.model.Accounts;
import ru.job4j.cinemaservice.model.Halls;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcStore {
    private static final JdbcStore INSTANCE = new JdbcStore();
    private Connection connection;
    private int size = 0;

    public static JdbcStore getInstance() {
        return INSTANCE;
    }


    public Halls addHolls(Halls halls) {
        String s = "INSERT into halls(id, rows, columns) VALUES(?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(s)) {

            statement.setInt(1, halls.getId());
            statement.setString(2, halls.getRows());
            statement.setString(3, halls.getColumns());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return halls;
    }

    public Halls[] getAll() {
        Halls[] halls = new Halls[size];


        try (Connection connection = init()) {
            String s = "SELECT id, rows, columns FROM halls";

            PreparedStatement statement = connection.prepareStatement(s);

            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) {
                Halls haller = new Halls();

                haller.setId(resultSet.getInt("id"));
                haller.setRows(resultSet.getString("rows"));
                haller.setColumns(resultSet.getString("columns"));

                for (int i = 0; i < size; i++) {
                    halls[i] = haller;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return halls;
    }


    public Accounts addAccounts(Accounts accounts) {
        String s1 = "INSERT INTO accounts(username, phone) VALUES (?, ?)";

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
