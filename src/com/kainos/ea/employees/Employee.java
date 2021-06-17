package com.kainos.ea.employees;

import com.kainos.ea.payroll.Payable;

public class Employee implements Payable {

    private String name;
    private String address;
    private String nin; // national insurance number TODO: validation on this string
    private String bankAccountNumber; // related to bank details TODO: validation
    private String sortCode; // related to bank details TODO: validation
    private int salary; // TODO: is this meant to be a default value 'starting salary'
    private int employeeNumber; // employee number from the database

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNin() {
        return nin;
    }

    public void setNin(String nin) {
        this.nin = nin;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Override
    public float calculatePay() {
        return 0;
    }
}
