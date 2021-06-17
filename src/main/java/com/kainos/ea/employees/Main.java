package com.kainos.ea.employees;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to the system");
        System.out.println("---------------------\n\nPlease enter your username");

        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();

        System.out.println("Please enter your password");
        String password = scanner.nextLine();


        ///////////////////////

        while (true) {
            System.out.println();
            System.out.println("Please select an option");
            System.out.println("---------------------");
            System.out.println("\nHR STAFF:");
            System.out.println("1) Add employee");
            System.out.println("2) Department Employees");
            System.out.println("\nFINANCE STAFF:");
            System.out.println("3) Employee Gross Pay");
            System.out.println("\nSALES MANAGER:");
            System.out.println("4) Highest Sales Total Employee");
            System.out.println("\nTALENT MANAGER:");
            System.out.println("5) Create Project");
            System.out.println("6) Assign to Project");
            System.out.println("7) See Assigned Employees");
            System.out.println("8) See Benched Employees");
            System.out.println("9) See Unassigned Projects");
            System.out.println("10) See Number of Employees on Project");
            System.out.print("\nOption: ");
            int option = scanner.nextInt();
            System.out.println();
            switch (option) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    UseCases.employeeSummaryReport();
                    break;
                case 3:
                    UseCases.grossPayReport();
                    break;
                case 4:
                    UseCases.highestSalesReport();
                    break;
                case 5:
                    UseCases.createProject();
                    break;
                case 6:
                    UseCases.assignToProject();
                    break;
                case 7:
                    UseCases.projectEmployeeReport();
                    break;
                case 8:
                    UseCases.employeesWithNoProjectReport();
                    break;
                case 9:
                    UseCases.projectsWithNoEmployeesReport();
                    break;
                case 10:
                    UseCases.numberOfEmployeesOnSpecificProject();
                    break;
            }

            System.out.println();
            System.out.println("Press enter to return to menu. Type exit then press enter to exit.");
            scanner = new Scanner(System.in);
            String res = scanner.nextLine();
            System.out.println(res);
            if (res.equals("exit")) return;
        }

    }

    /**
     * Use case 1: Allows HR member to add an employee
     * TODO: Needs SQL SCripts to input the data
     */
    public static void addEmployee(Scanner addEmp) {

        System.out.println("Please enter the following details for the employee:");
        System.out.println("----------------------------------------------------");
        System.out.println("Full name");
        String empName = addEmp.nextLine();

        System.out.println("Address");
        String empAddress = addEmp.nextLine();

        System.out.println("National Insurance Number");
        String empNIN = addEmp.nextLine();

        System.out.println("Bank Account Number");
        String empBankAccNum = addEmp.nextLine();

        System.out.println("Sort Code");
        String empSortCode = addEmp.nextLine();

        System.out.println("Salary");
        Double empSalary = addEmp.nextDouble();

        department empDepartment = department.HR;

        switch (department(addEmp)) {
            case 1:
                empDepartment = department.HR;
                break;
            case 2:
                empDepartment = department.FINANCE;
                break;
            case 3:
                empDepartment = department.TALENT;
                break;
            case 4:
                empDepartment = department.TECHNICAL;
                break;
            case 5:
                empDepartment = department.SALES;
                break;
        }


        boolean isManager = checkIfManager(addEmp);

        System.out.println(empName + " " + empAddress + " " + empNIN + " " + empBankAccNum + " " + empSortCode + " " + empSalary + " " + empDepartment.toString() + " " + isManager);
        UseCases.addEmployee(empName, empAddress, empNIN, empBankAccNum, empSortCode, empSalary, empDepartment, isManager);
    }

    public static boolean checkIfManager(Scanner addEmp) {
        System.out.println("Is the employee a manager? (Y/N)");
        String m = addEmp.nextLine();

        if (m.equals("Y")) {
            return true;
        } else if (m.equals("N")) {
            return false;
        } else {
            System.out.println("Please enter either Y or N");
            return checkIfManager(addEmp);
        }
    }

    public static int department(Scanner addEmp) {

        System.out.println("Please enter their department(1-5)\n1. HR\n2.FINANCE\n3.TALENT\n4.TECHNICAL\n5.SALES");
        int department = addEmp.nextInt();

        switch (department) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            default:
                System.out.println("Please enter 1, 2 , 3 , 4 or 5");
                return department(addEmp);
        }
    }
}

