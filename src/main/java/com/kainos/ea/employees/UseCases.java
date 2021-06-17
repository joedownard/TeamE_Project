package com.kainos.ea.employees;

import com.kainos.ea.dbUtils.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UseCases {
    private final static float taxRate = 0.25f;

    public static void grossPayReport () {
        Connection connection = DBConnection.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM `Gross Pay`");
            while (rs.next()) {
                System.out.println(String.format("%s (Employee ID: %s) has a gross pay of £%s", rs.getString("emp_name"), rs.getString("emp_id"), rs.getString("Gross pay")));
            }
        } catch (SQLException e) {
            System.out.println("Unable to query the database to complete this report!");
        }
    }

    public static void highestSalesReport () {
        Connection connection = DBConnection.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM `Highest Sales`");
            while (rs.next()) {
                System.out.println(String.format("%s (Employee ID: %s) had the highest sales of £%s", rs.getString("emp_name"), rs.getString("emp_id"), rs.getString("total_sales_value")));
            }
        } catch (SQLException e) {
            System.out.println("Unable to query the database to complete this report!");
        }
    }

    public static void employeeSummaryReport () {
        Connection connection = DBConnection.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM `Employee Summary`");
            while (rs.next()) {
                System.out.println(String.format("%s (Employee ID: %s) is in the %s department.", rs.getString("emp_name"), rs.getString("emp_id"), rs.getString("department")));
            }
        } catch (SQLException e) {
            System.out.println("Unable to query the database to complete this report!");
        }
    }

    public static void employeesWithNoProjectReport () {
        Connection connection = DBConnection.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM `Employees with no projects`");
            while (rs.next()) {
                System.out.println(String.format("%s (Employee ID: %s) has not been assigned any projects.", rs.getString("Employee Name"), rs.getString("Employee ID")));
            }
        } catch (SQLException e) {
            System.out.println("Unable to query the database to complete this report!");
            System.out.println(e.getMessage());
        }
    }

    public static void projectsWithNoEmployeesReport () {
        Connection connection = DBConnection.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM `Projects with no employees`");
            while (rs.next()) {
                System.out.println(String.format("%s (Project ID: %s) has not been assigned any employees.", rs.getString("Project Name"), rs.getString("Project ID")));
            }
        } catch (SQLException e) {
            System.out.println("Unable to query the database to complete this report!");
            System.out.println(e.getMessage());
        }
    }

    public static void projectEmployeeReport () {
        Connection connection = DBConnection.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM `Projects with employees`");
            while (rs.next()) {
                System.out.println(String.format("%s (Project ID: %s) has been assigned %s (Employee ID: %s).", rs.getString("project_name"), rs.getString("project_id"), rs.getString("emp_name"), rs.getString("emp_id")));
            }
        } catch (SQLException e) {
            System.out.println("Unable to query the database to complete this report!");
            System.out.println(e.getMessage());
        }
    }

    public static void addEmployee(String name, String address, String nin, String ban, String sortCode, double salary, department depart, boolean isManager) {
        Connection connection = DBConnection.getConnection();
        try {
            Statement st = connection.createStatement();
            int rs = st.executeUpdate(
                    "INSERT INTO Employee (emp_name, address, nin, ban, sortcode, salary, department, manager) VALUES ('" + name + "', '" + address + "', '" + nin + "', '" + ban + "', '" + sortCode + "', " + salary + ", '" + depart.toString() + "', " + (isManager ? 1 : 0) +");");

        } catch (SQLException e) {
            System.out.println("Unable to query the database to complete this action!");
            System.out.println(e.getMessage());
        }
    }
}
