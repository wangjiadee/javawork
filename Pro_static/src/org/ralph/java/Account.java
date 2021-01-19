package org.ralph.java;

public class Account {
    private int id;
    private String password = "000000";
    private double balance;

    private static double interestRate;
    private static double minMoney = 1000;
    private static int init = 1010;

    public Account(){
        id = init++;
    }

    public Account(String password,double balance){
        id = init++;
        this.password = password;
        this.balance = balance;
    }

    public static double getMinMoney() {
        return minMoney;
    }

    public static void setMinMoney(double minMoney) {
        Account.minMoney = minMoney;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        Account.interestRate = interestRate;
    }


    public int getId() {
        return id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}
