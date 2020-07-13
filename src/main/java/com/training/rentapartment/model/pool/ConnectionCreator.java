package com.training.rentapartment.model.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionCreator {
    private static Logger logger = LogManager.getLogger(ConnectionCreator.class);

    private static final String DB_PROPERTIES = "C:\\Users\\smugl\\IdeaProjects\\rentapartment\\src\\main\\resources*\\res\\config.properties"; //todo
    private static final String DB_HOST = "db.host";
    private static final String DB_LOGIN = "db.login";
    private static final String DB_PASSWORD = "db.password";

    private String host;
    private String login;
    private String password;

    ConnectionCreator() {
        Properties properties = new Properties();
        try (InputStream inputStream = Files.newInputStream(Paths.get(DB_PROPERTIES))) {
            properties.load(inputStream);
            this.host = properties.getProperty(DB_HOST);
            this.login = properties.getProperty(DB_LOGIN);
            this.password = properties.getProperty(DB_PASSWORD);
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException | IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(host, login, password);
        } catch (SQLException e) {
            logger.error(e);
        }
        return connection;
    }
}

