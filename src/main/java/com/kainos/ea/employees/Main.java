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

        System.out.println(userName + " " + password);

        addEmployee(scanner);
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

