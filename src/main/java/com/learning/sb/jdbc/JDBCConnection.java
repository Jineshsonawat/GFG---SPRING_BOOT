package com.learning.sb.jdbc;

import java.sql.*;

public class JDBCConnection {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:8080/postgres";
        String user = "postgres";
        String password = "1101";
        String query = "select * from public.users";

//        try() - try with resources
        try(Connection connection = DriverManager.getConnection(url , user, password)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("Connected to Database");
            while(resultSet.next()){
                System.out.println(resultSet.getString("name") + "-" + resultSet.getString("age"));
            }
//            We need to close the connection that we open to connect with database. but we also can use try with resources where we can put the connection in () that we want to close and no need to write the close().
//            No need to this now
//            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            System.out.println(e.getMessage());
        }
    }
}
