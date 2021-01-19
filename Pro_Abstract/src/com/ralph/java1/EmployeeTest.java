package com.ralph.java1;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee manager = new Manager("ralph",00001,7000,10000);
        manager.work();

        CommonEmployee commonEmployee = new CommonEmployee();
        commonEmployee.work();
    }
}

