package com.ralph.java;

public class ManKind {
    private int sex;
    private int salary;

    public ManKind(){

    }

    public ManKind(int sex,int salary){
        this.sex = sex;
        this.salary = salary;
    }

    public int getSex() {
        return sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void manOrWoman(){
        if(sex == 1){
            System.out.println("This man");
        }else if(sex == 0){
            System.out.println("This Woman");
        }
    }

    public void employeed(){
//        if(salary == 0){
//            System.out.println("Fucking no jobs");
//        }else if(sex != 0){
//            System.out.println("Good jobs");
//        }

        String jobInfo = (salary == 0)? "Fucking no jobs" : "Good jobs";
        System.out.println(jobInfo);
    }


}
