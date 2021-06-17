CREATE DATABASE `ET_Joseph`;

USE `ET_Joseph`;

CREATE TABLE Employee (
    emp_id SMALLINT AUTO_INCREMENT,
    emp_name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
	nin CHAR(9) NOT NULL,
	ban CHAR(10) NOT NULL,
    sortcode CHAR(6) NOT NULL,
    salary DECIMAL(11, 2) NOT NULL,
    department ENUM('HR', 'FINANCE', 'SALES', 'TECHNICAL', 'TALENT') NOT NULL,
    manager bit NOT NULL,
    PRIMARY KEY (emp_id)
);

CREATE TABLE Technical_Employee (
    emp_id SMALLINT NOT NULL,
    cv LONGBLOB NOT NULL,
    photo LONGBLOB NOT NULL,
    PRIMARY KEY (emp_id),
    FOREIGN KEY (emp_id)
        REFERENCES Employee (emp_id)
);

CREATE TABLE Project (
    project_id SMALLINT NOT NULL AUTO_INCREMENT,
    project_name VARCHAR(100) NOT NULL,
    PRIMARY KEY (project_id)
);

CREATE TABLE Technical_Project (
    emp_id SMALLINT NOT NULL,
    project_id SMALLINT NOT NULL,
    PRIMARY KEY (emp_id , project_id),
    FOREIGN KEY (emp_id)
        REFERENCES Technical_Employee (emp_id),
    FOREIGN KEY (project_id)
        REFERENCES Project (Project_id)
);

CREATE TABLE Sales_Employee (
    emp_id SMALLINT NOT NULL,
    commission_rate DECIMAL(2,2) NOT NULL,
    total_sales_value DECIMAL(11, 2) NOT NULL,
    PRIMARY KEY (emp_id),
    FOREIGN KEY (emp_id)
        REFERENCES Employee (emp_id)
);