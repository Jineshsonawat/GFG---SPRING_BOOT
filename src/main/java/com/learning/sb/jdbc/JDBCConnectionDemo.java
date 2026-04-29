package com.learning.sb.jdbc;

import com.learning.sb.model.Employee;
import org.postgresql.Driver;

import java.sql.*;

public class JDBCConnectionDemo {


    public static final String url = "jdbc:postgresql://localhost:8080/postgres";
    public static final String user = "postgres";
    public static final String password = "1101";

    public static void main(String[] args) throws SQLException {


        String createCommand = "CREATE TABLE employee ("
                + "id SERIAL PRIMARY KEY, "
                + "name VARCHAR(100), "
                + "department VARCHAR(100))";
        String selectCommand = "Select * from public.employee";

//        runUpdate(createCommand);
//        addEmployee(new Employee("Dharmesh", "IOS"));
        deleteEmployeeByName(new Employee("Dharmesh"));

        ResultSet r = runQuery(selectCommand);
        while (r != null && r.next()) {
            System.out.println(r.getString("name") + "-" + r.getString("department"));
        }

    }

    public static void addEmployee(Employee e) {
//        This is so hard to write so we can use Prepared Statement to get rid of this.
//        String insertCommand = "INSERT INTO employee (name, department) VALUES ('"
//                + e.getName() + "', '"
//                + e.getDepartment() + "')";
        String insertCommand = "INSERT INTO employee (name, department) VALUES (?, ?)";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
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

        try (Connection connection = DriverManager.getConnection(url,user,password)) {
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

    public static ResultSet runQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
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
