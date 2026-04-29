package com.learning.sb.jdbc;

import java.sql.*;

public class JDBCConnectionDemo {

    public static final String url = "jdbc:postgresql://localhost:8080/postgres";
    public static final String user = "postgres";
    public static final String password = "1101";

    public static void main(String[] args) {

        String query = "INSERT INTO employee (name, department) VALUES ('Jinesh', 'IT')";
        String ddlCommand = "CREATE TABLE employee ("
                + "id SERIAL PRIMARY KEY, "
                + "name VARCHAR(100), "
                + "department VARCHAR(100))";

        runDDLonDB(ddlCommand);
        runDMLonDB(query);

    }

    public static void runDDLonDB (String query){
        //        try() - try with resources
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Connected to Database");

//            We need to close the connection that we open to connect with database. but we also can use try with resources where we can put the connection in () that we want to close and no need to write the close().
//            No need to this now
//            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            System.out.println(e.getMessage());
        }
    }

    public static void runDMLonDB (String query){
        //        try() - try with resources
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Connected to Database");

//            We need to close the connection that we open to connect with database. but we also can use try with resources where we can put the connection in () that we want to close and no need to write the close().
//            No need to this now
//            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            System.out.println(e.getMessage());
        }
    }

}
