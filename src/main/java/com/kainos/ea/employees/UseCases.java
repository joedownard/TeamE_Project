package com.kainos.ea.employees;

import com.kainos.ea.dbUtils.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UseCases {
    private final static float taxRate = 0.25f;

    public static void grossPayReport() {
        if (Main.departmentCh != "F") {
            System.out.println("Error: Only Finance employees can access this function");
            return;
        }
        Connection connection = DBConnection.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM `Gross Pay`");
            while (rs.next()) {
                System.out.println(String.format("%s (Employee ID: %s) has a gross pay of £%s", rs.getString("emp_name"), rs.getString("emp_id"), taxRate * rs.getFloat("Gross pay")));
            }
        } catch (SQLException e) {
            System.out.println("Unable to query the database to complete this report!");
        }
    }

    public static void highestSalesReport() {
        if (Main.departmentCh != "S") {
            System.out.println("Error: Only Sales Managers can access this function");
            return;
        }
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

    public static void employeeSummaryReport() {
        if (Main.departmentCh != "H") {
            System.out.println("Error: Only HR employees can access this function");
            return;
        }
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

    public static void employeesWithNoProjectReport() {
        if (Main.departmentCh != "T") {
            System.out.println("Error: Only Talent Managers can access this function");
            return;
        }
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

    public static void projectsWithNoEmployeesReport() {
        if (Main.departmentCh != "T") {
            System.out.println("Error: Only Talent Managers can access this function");
            return;
        }
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

    public static void numberOfEmployeesOnSpecificProject() {
        if (Main.departmentCh != "T") {
            System.out.println("Error: Only Talent Managers can access this function");
            return;
        }
        Connection connection = DBConnection.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM Project");
            while (rs.next()) {
                System.out.println(String.format("%s (Project ID: %s)", rs.getString("project_name"), rs.getString("project_id")));
            }
        } catch (SQLException e) {
            System.out.println("Unable to query the database to complete this report!");
            System.out.println(e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Which project would you like to find the number of employees assigned to?");
        int project_id = scanner.nextInt();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT project_name, project_id, COUNT(*) FROM Technical_Employee JOIN Technical_Project USING (emp_id) JOIN Project USING(project_id) WHERE project_id =" + project_id + ";");
            while (rs.next()) {
                System.out.println(String.format("%s (Project ID: %s) has been assigned %d employees.", rs.getString("project_name"), rs.getString("project_id"), rs.getInt("COUNT(*)")));
            }
        } catch (SQLException e) {
            System.out.println("Unable to query the database to complete this report!");
            System.out.println(e.getMessage());
        }
    }

    public static void projectEmployeeReport() {
        if (Main.departmentCh != "T") {
            System.out.println("Error: Only Talent Managers can access this function");
            return;
        }
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

    public static void createProject() {
        if (Main.departmentCh != "T") {
            System.out.println("Error: Only Talent Managers can access this function");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Project Name: ");
        String project_name = scanner.nextLine();

        Connection connection = DBConnection.getConnection();
        try {
            Statement st = connection.createStatement();
            int rs = st.executeUpdate(
                    "INSERT INTO Project (project_name) VALUES ('" + project_name + "')");
        } catch (SQLException e) {
            System.out.println("Unable to query the database to complete this report!");
            System.out.println(e.getMessage());
        }
    }

    public static void assignToProject() {
        if (Main.departmentCh != "T") {
            System.out.println("Error: Only Talent Managers can access this function");
            return;
        }
        Connection connection = DBConnection.getConnection();
        System.out.println("Projects: ");
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM Project");
            while (rs.next()) {
                System.out.println(String.format("%s (Project ID: %s)", rs.getString("project_name"), rs.getString("project_id")));
            }
        } catch (SQLException e) {
            System.out.println("Unable to query the database to complete this report!");
            System.out.println(e.getMessage());
        }

        System.out.println("\nTechnical Employees: ");

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM Technical_Employee JOIN Employee USING(emp_id)");
            while (rs.next()) {
                System.out.println(String.format("%s (Employee ID: %s)", rs.getString("emp_name"), rs.getString("emp_id")));
            }
        } catch (SQLException e) {
            System.out.println("Unable to query the database to complete this report!");
            System.out.println(e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Project id: ");
        int project_id = scanner.nextInt();
        System.out.println("Employee id: ");
        int emp_id = scanner.nextInt();


        try {
            Statement st = connection.createStatement();
            int rs = st.executeUpdate(
                    "INSERT INTO Technical_Project (emp_id, project_id) VALUES (" + emp_id + ", " + project_id + ")");
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
                    "INSERT INTO Employee (emp_name, address, nin, ban, sortcode, salary, department, manager) VALUES ('" + name + "', '" + address + "', '" + nin + "', '" + ban + "', '" + sortCode + "', " + salary + ", '" + depart.toString() + "', " + (isManager ? 1 : 0) + ");");

            System.out.println("Employee successfully added");
        } catch (SQLException e) {
            System.out.println("Unable to query the database to complete this action!");
        }
    }
}
