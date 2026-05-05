package com.learning.sb.jdbc;

import com.learning.sb.entity.Employee;


import java.sql.*;

public class JDBCDemoOfUsingSingleConnection {

    private static final Connection connection = MyDBConnection.getConnection();


    public static void main(String[] args) throws SQLException {

        try {
            String createCommand = "CREATE TABLE employee ("
                    + "id SERIAL PRIMARY KEY, "
                    + "name VARCHAR(100), "
                    + "department VARCHAR(100))";
            String selectCommand = "Select * from public.employee";

//        runUpdate(createCommand);
//            addEmployee(new Employee("Dharmesh", "IOS"));
//            addEmployee(new Employee("Janak", "Design"));
            deleteEmployeeByName(new Employee("Jinesh"));


            ResultSet r = runQuery(selectCommand);
            while (r != null && r.next()) {
                System.out.println(r.getString("name") + "-" + r.getString("department"));
            }
        }finally{
            connection.close();;
        }

    }

    public static void addEmployee(Employee e) {

        String insertCommand = "INSERT INTO employee (name, department) VALUES (?, ?)";
        try {
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertCommand)) {

                preparedStatement.setString(1, e.getName());
                preparedStatement.setString(2, e.getDepartment());

                preparedStatement.executeUpdate();
                System.out.println("Record inserted successfully!");
            }
        } catch (SQLException ex) {
            System.out.println("Failed to Insert the data");
            System.out.println("while Insert the data, Error - " + ex.getMessage());
        }


    }

    public static void deleteEmployeeByName(Employee e) {
        String deleteCommand = "DELETE FROM employee WHERE name = ?";

        try {
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteCommand)) {
                preparedStatement.setString(1, e.getName());

                preparedStatement.executeUpdate();
                System.out.println("Employee Deleted.");
            }
        } catch (SQLException ex) {
            System.out.println("Deletion Failed - " + ex.getMessage());
        }
    }

    public static void runUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Connected to Database");


        } catch (SQLException e) {
            System.out.println("Connection Failed");
            System.out.println(e.getMessage());
        }
    }

    public static ResultSet runQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("Connected to Database");
            return resultSet;

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            System.out.println(e.getMessage());
            return null;
        }
    }

}
