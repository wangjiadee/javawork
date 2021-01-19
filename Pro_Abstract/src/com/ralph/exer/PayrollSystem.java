package com.ralph.exer;

import java.util.Calendar;

public class PayrollSystem {
    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
//        System.out.println(month);

        Employee[] emps = new Employee[2];
        emps[0] = new SalariedEmployee("Fuck",1002, new MyDate(1998,2,22),10000);
        emps[1] = new HourlyEmployee("MDZZ",1002, new MyDate(1998,10,26),60,2100);


        for (int i = 0;i <emps.length;i++){
            System.out.println(emps[i]);
            double salary = emps[i].earnings();
            System.out.println("u salary : " + salary);

            if((month + 2) == emps[i].getBirthday().getMonth()){
                System.out.println("Happy birthday! give u 100￥");
            }

        }
    }
}
