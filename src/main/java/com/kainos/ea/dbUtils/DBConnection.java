package com.kainos.ea.dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection conn;

    public static Connection getConnection() {
        String user;
        String password;
        String host;

        if (conn != null) {
            return conn;
        }

        try {
            // Bad practice alert!
            user = "empsuser";
            password = "empPwd!";
            host = "localhost";

            conn = DriverManager.getConnection("jdbc:mysql://"
                    + host + "/employees?useSSL=false", user, password);
            return conn;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
