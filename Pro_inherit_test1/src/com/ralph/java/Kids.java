package com.ralph.java;

public class Kids extends ManKind {
    private int yearsOld;

    public  Kids(){

    }
    public  Kids(int yearsOld){
        this.yearsOld = yearsOld;
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public void printAge(){
        System.out.println("YaersOld :" + yearsOld);
    }

    @Override
    public void employeed(){
        System.out.println("Fucking jobs");
    }
}
