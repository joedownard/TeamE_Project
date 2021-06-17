package com.kainos.ea.employees;

public class Employee {

    private String name;
    private String address;
    private String nin; // national insurance number TODO: validation on this string
    private String bankAccountNumber; // related to bank details TODO: validation
    private String sortCode; // related to bank details TODO: validation
    protected int salary; // TODO: is this meant to be a default value 'starting salary'
    protected int employeeNumber; // employee number from the database

}
