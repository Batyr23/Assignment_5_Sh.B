package com.company.data;

import com.company.data.interfaces.IDB;

import java.sql.*;

public class DB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/MyDB";
        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "");

            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}