package com.kainos.ea.dbUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {
    private static Connection conn;

    public static Connection getConnection() {
        String user;
        String password;
        String host;

        if (conn != null) {
            return conn;
        }
        FileInputStream propsStream =
                null;
        try {
            propsStream = new FileInputStream("Database_ET.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Properties props = new Properties();
        try {
            props.load(propsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        user = props.getProperty("user");
        password = props.getProperty("password");
        host = props.getProperty("host");

        try {

            conn = DriverManager.getConnection("jdbc:mysql://"
                    + host + "/Database_ET?useSSL=false", user, password);
            return conn;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
