package com.kainos.ea.dbUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBStatements {
    public static int UpdateStatement() {

        return 0;
    }

    public static ResultSet SelectStatement(String sql, Connection connection) {
        try {
            Statement st = connection.createStatement();
            return  st.executeQuery(sql);
        } catch (SQLException e) {

        }
        return null;
    }
}
