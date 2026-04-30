package com.learning.sb.jdbc;

import com.learning.sb.mapper.EmployeeRowMapper;
import com.learning.sb.model.Employee;
import org.springframework.jdbc.core.RowMapper;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCConnectionDemo {


    public static final String url = "jdbc:postgresql://localhost:8080/postgres";
    public static final String user = "postgres";
    public static final String password = "1101";

    public static void main(String[] args) throws SQLException {


        String createCommand = "CREATE TABLE employee ("
                + "id SERIAL PRIMARY KEY, "
                + "name VARCHAR(100), "
                + "department VARCHAR(100))";


//        runUpdate(createCommand);
//        addEmployee(new Employee("Dharmesh", "IOS"));
//        deleteEmployeeByName(new Employee("Dharmesh"));
        System.out.println(addAllEmployee());


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

    public static List<Employee> addAllEmployee() throws SQLException {
        List<Employee> list = new ArrayList<Employee>();
        String selectCommand = "Select * from public.employee";
        ResultSet rs = runQuery(selectCommand);

//        Instead of doing this we can use Row Mapper. It's same just the clean code here
//        while(rs != null && rs.next()){
//            list.add(
//                    new Employee(
//                    rs.getInt("id"),
//                    rs.getString("name"),
//                    rs.getString("department")
//            ));
//        }

        RowMapper<Employee> rowMapper = new EmployeeRowMapper();

        int i = 0;
//        No use of Index just we can make it usable as we need.
        while(rs != null && rs.next()){
            list.add(rowMapper.mapRow(rs, i++));
        }

        return list;

    }

}
