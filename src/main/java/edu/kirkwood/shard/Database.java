package edu.kirkwood.shard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "java-demo.mysql.database.azure.com";
    private static final String USER = "k0866951";
    private static final String PASSWORD = "X@#@kwYOn8ac8vK01V^@";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
