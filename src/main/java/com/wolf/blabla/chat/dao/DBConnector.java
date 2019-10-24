package com.wolf.blabla.chat.dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnector {
    private static final Logger LOGGER = Logger.getLogger(DBConnector.class);

    private final String url;
    private final String user;
    private final String password;

    public DBConnector(String fileConfigName) {
        ResourceBundle resource = ResourceBundle.getBundle(fileConfigName);
        this.url = resource.getString("db.url");
        this.user = resource.getString("db.user");
        this.password = resource.getString("db.password");
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            LOGGER.error("");
            throw new DataBaseRuntimeException(e);
        }
    }
}
