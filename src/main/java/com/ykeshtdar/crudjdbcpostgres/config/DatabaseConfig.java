package com.ykeshtdar.crudjdbcpostgres.config;

import java.sql.*;

public class DatabaseConfig {
    String url = "jdbc:postgresql://localhost:5432/crudjdbc";
    String username = "postgres";
    String password = "3539";

    public Connection getConnection(){
        Connection conn = null;
        try {
             conn = DriverManager.getConnection(url,username,password);
            System.out.println("successfully connected");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public void closeConnection(Connection con){
        try {
            if (con!=null){
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
