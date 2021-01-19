package org.ralph.java;

public class AccountTest {
    public static void main(String[] args) {
        Account acc = new Account();
        Account acc2 = new Account("20191109",7000);

        Account.setInterestRate(0.012);
        Account.setMinMoney(2000);
        System.out.println(acc);
        System.out.println(acc2);

        System.out.println(acc.getInterestRate());
        System.out.println(acc.getMinMoney());
        System.out.println(acc2.getInterestRate());
        System.out.println(acc2.getMinMoney());
    }
}
