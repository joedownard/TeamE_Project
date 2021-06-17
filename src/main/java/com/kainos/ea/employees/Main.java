package com.kainos.ea.employees;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Main {
    public static String departmentCh = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the system");
        boolean signedIn = false;
        do {
            System.out.println("---------------------\n\nPlease enter your department:");
            System.out.println("HR (H)");
            System.out.println("FINANCE (F)");
            System.out.println("SALES (S)");
            System.out.println("TALENT (T)");
            System.out.print("\nOption: ");
            departmentCh = scanner.nextLine();

            if (departmentCh.equals("H") || departmentCh.equals("F") || departmentCh.equals("S") || departmentCh.equals("T")) {
                signedIn = true;
            } else {
                System.out.println("Error: Please select a department listed");
            }
            System.out.println();
        } while (!signedIn);


        ///////////////////////

        while (true) {
            System.out.println();
            System.out.println("Please select an option");
            System.out.println("---------------------");
            System.out.println("\nHR STAFF:");
            System.out.println("1) Add Employee");
            System.out.println("2) Add Sales Employee");
            System.out.println("3) Department Employees");
            System.out.println("\nFINANCE STAFF:");
            System.out.println("4) Employee Gross Pay");
            System.out.println("\nSALES MANAGER:");
            System.out.println("5) Highest Sales Total Employee");
            System.out.println("\nTALENT MANAGER:");
            System.out.println("6) Create Project");
            System.out.println("7) Assign to Project");
            System.out.println("8) See Assigned Employees");
            System.out.println("9) See Benched Employees");
            System.out.println("10) See Unassigned Projects");
            System.out.println("11) See Number of Employees on Project");
            System.out.print("\nOption: ");
            int option = scanner.nextInt();
            System.out.println();
            switch (option) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    UseCases.addSalesEmployee();
                    break;
                case 3:
                    UseCases.employeeSummaryReport();
                    break;
                case 4:
                    UseCases.grossPayReport();
                    break;
                case 5:
                    UseCases.highestSalesReport();
                    break;
                case 6:
                    UseCases.createProject();
                    break;
                case 7:
                    UseCases.assignToProject();
                    break;
                case 8:
                    UseCases.projectEmployeeReport();
                    break;
                case 9:
                    UseCases.employeesWithNoProjectReport();
                    break;
                case 10:
                    UseCases.projectsWithNoEmployeesReport();
                    break;
                case 11:
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
    public static void addEmployee() {
        if (!Main.departmentCh.equals("H")) {
            System.out.println("Error: Only HR employees can access this function");
            return;
        }
        Scanner addEmp = new Scanner(System.in);
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

        System.out.println("Please enter their department(1-5)\n1.HR\n2.FINANCE\n3.TALENT\n4.TECHNICAL\n5.SALES");
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

