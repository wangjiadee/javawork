package com.ralph.java.sampleMould;

public class BankTest {
}


class Bank{

    private Bank(){}

    private static Bank instance = null;

    public static synchronized Bank getInstance(){
            if (instance == null){
                synchronized (Bank.class){
                    if (instance == null){
                        instance = new Bank();
                    }
                }
            }
            return instance;

    }
}