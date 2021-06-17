package com.kainos.ea.employees;

import com.kainos.ea.dbUtils.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UseCases {
    private final static float taxRate = 0.25f;

    public static void grossPayReport () {
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
            System.out.println("If you continue to have issues please contact your system administrator and quote the following error message.");
            System.out.println(e.getMessage());
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
            System.out.println("If you continue to have issues please contact your system administrator and quote the following error message.");
            System.out.println(e.getMessage());
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
            System.out.println("If you continue to have issues please contact your system administrator and quote the following error message.");
            System.out.println(e.getMessage());
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
            System.out.println("If you continue to have issues please contact your system administrator and quote the following error message.");
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
            System.out.println("If you continue to have issues please contact your system administrator and quote the following error message.");
            System.out.println(e.getMessage());
        }
    }

    public static void numberOfEmployeesOnSpecificProject () {
        Connection connection = DBConnection.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM Project");
            while (rs.next()) {
                System.out.println(String.format("%s (Project ID: %s)", rs.getString("project_name"), rs.getString("project_id")));
            }
        } catch (SQLException e) {
            System.out.println("Unable to list the projects from the databases!");
            System.out.println("If you continue to have issues please contact your system administrator and quote the following error message.");
            System.out.println(e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Which project would you like to find the number of employees assigned to?");
        int project_id = scanner.nextInt();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT project_name, project_id, COUNT(*) FROM Technical_Employee JOIN Technical_Project USING (emp_id) JOIN Project USING(project_id) WHERE project_id ="+ project_id + ";");
            while (rs.next()) {
                System.out.println(String.format("%s (Project ID: %s) has been assigned %d employees.", rs.getString("project_name"), rs.getString("project_id"), rs.getInt("COUNT(*)")));
            }
        } catch (SQLException e) {
            System.out.println("Unable to complete your request!");
            System.out.println("Ensure the project id you have entered exists.");
            System.out.println("If you continue to have issues please contact your system administrator and quote the following error message.");
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
            System.out.println("If you continue to have issues please contact your system administrator and quote the following error message.");
            System.out.println(e.getMessage());
        }
    }

    public static void createProject () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Project Name: ");
        String project_name = scanner.nextLine();

        Connection connection = DBConnection.getConnection();
        try {
            Statement st = connection.createStatement();
            int rs = st.executeUpdate(
                    "INSERT INTO Project (project_name) VALUES ('"+project_name+"')");
        } catch (SQLException e) {
            System.out.println("Unable to complete your request");
            System.out.println("Ensure the project name is valid.");
            System.out.println("If you continue to have issues please contact your system administrator and quote the following error message.");
            System.out.println(e.getMessage());
        }
    }

    public static void assignToProject() {
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
            System.out.println("Unable to retrieve the list of projects!");
            System.out.println("Please contact your systems administrator and quote the following error message.");
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
            System.out.println("Unable to list the technical employees available to be assigned!");
            System.out.println("Please contact your systems administrator and quote the following error message.");
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
                    "INSERT INTO Technical_Project (emp_id, project_id) VALUES ("+emp_id+", "+project_id+")");
        } catch (SQLException e) {
            System.out.println("Unable to complete your request!");
            System.out.println("Ensure you the employee is not already assigned to the project and that both the employee and project ids are valid.");
            System.out.println("If you continue to have issues please contact your system administrator and quote the following error message.");
            System.out.println(e.getMessage());
        }
    }

    public static void addEmployee(String name, String address, String nin, String ban, String sortCode, double salary, department depart, boolean isManager) {
        Connection connection = DBConnection.getConnection();
        try {
            Statement st = connection.createStatement();
            int rs = st.executeUpdate(
                    "INSERT INTO Employee (emp_name, address, nin, ban, sortcode, salary, department, manager) VALUES ('" + name + "', '" + address + "', '" + nin + "', '" + ban + "', '" + sortCode + "', " + salary + ", '" + depart.toString() + "', " + (isManager ? 1 : 0) +");");

            System.out.println("Employee successfully added");
        } catch (SQLException e) {
            System.out.println("Unable to complete your request!");
            System.out.println("Please ensure the fields follow the correct format.");
            System.out.println("If you continue to have issues please contact your system administrator and quote the following error message.");
            System.out.println(e.getMessage());
        }
    }

    public static void addSalesEmployee () {
        Connection connection = DBConnection.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM Employee LEFT OUTER JOIN Sales_Employee USING(emp_id) WHERE commission_rate IS NULL");
            while (rs.next()) {
                System.out.println(String.format("%s (Employee ID: %s), who is currently in department %s", rs.getString("emp_name"), rs.getString("emp_id"), rs.getString("department")));
            }
        } catch (SQLException e) {
            System.out.println("Unable to list the employees available to be assigned!");
            System.out.println("Please contact your systems administrator and quote the following error message.");
            System.out.println(e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the id of the employee you wish to add to sales employee.");
        int emp_id = scanner.nextInt();
        System.out.println("Please enter the commission rate for the employee.");
        int commission_rate = scanner.nextInt();
        System.out.println("Please enter the sales value for the employee.");
        int sales_value = scanner.nextInt();

        try {
            Statement st = connection.createStatement();
            int rs = st.executeUpdate(
                    "INSERT INTO Sales_Employee (emp_id, commission_rate, total_sales_value) VALUES ("+emp_id+", "+commission_rate+", "+sales_value+");");

            System.out.println("Sales Employee successfully added");
        } catch (SQLException e) {
            System.out.println("Unable to complete your request!");
            System.out.println("Please ensure the fields follow the correct format.");
            System.out.println("If you continue to have issues please contact your system administrator and quote the following error message.");
            System.out.println(e.getMessage());
        }
    }
}
