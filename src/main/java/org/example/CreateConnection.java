package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnection {

    public static Connection conn;

    public static Connection getConnection() {

        try {
            //load jdbc driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            String userName = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost:3306/test";
            //we use driver manager which use jdbc driver to connect to database.

            conn = DriverManager.getConnection(url, userName, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;

    }
}
