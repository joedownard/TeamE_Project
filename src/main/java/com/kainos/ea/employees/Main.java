package com.kainos.ea.employees;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to the system");
        System.out.println("---------------------\n\nPlease enter your username");

        Scanner login = new Scanner(System.in);
        String userName = login.nextLine();

        System.out.println("Please enter your password");
        String password = login.nextLine();

        System.out.println(userName + " " + password);

    }
}
