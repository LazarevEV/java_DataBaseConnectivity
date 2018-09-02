package code;

import java.sql.*;

public class DBConnection {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    private String localhost = "MSI";
    private String dbName = "oracleDB";
    private String url = "jdbc:oracle:thin:@"+localhost+":1521:"+dbName;

    public void setConnection(String user, String password) throws ClassNotFoundException {
        //set Oracle Java DataBase Connectivity Driver
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println(url);
        //crate Connection
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Success!");
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }
}
