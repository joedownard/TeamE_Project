package com.kainos.ea.employees;

public enum department {
    HR ("HR"),
    FINANCE ("FINANCE"),
    TALENT ("TALENT"),
    TECHNICAL ("TECHNICAL"),
    SALES ("SALES");

    private final String name;

    private department(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }
}
