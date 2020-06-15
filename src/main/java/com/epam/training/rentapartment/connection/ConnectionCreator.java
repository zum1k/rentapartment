package com.epam.training.rentapartment.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionCreator {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionCreator.class);

    private static final String DB_PROPERTIES = "config.properties";
    private static final String DB_HOST = "db.host";
    private static final String DB_LOGIN = "db.login";
    private static final String DB_PASSWORD = "db.password";

    private String host;
    private String login;
    private String password;

    ConnectionCreator() {
        ClassLoader classLoader = getClass().getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(DB_PROPERTIES)) {
            Properties properties = new Properties();
            properties.load(inputStream);

            this.host = properties.getProperty(DB_HOST);
            this.login = properties.getProperty(DB_LOGIN);
            this.password = properties.getProperty(DB_PASSWORD);

            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException | IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(host, login, password);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return connection;
    }
}


