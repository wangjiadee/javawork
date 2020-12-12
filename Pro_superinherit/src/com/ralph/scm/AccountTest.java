package com.ralph.scm;

public class AccountTest {
    public static void main(String[] args) {

        Account acct = new Account(1122, 20000, 0.045);

        acct.withdraw(30000);
        System.out.println("Your ac count balance is:" + acct.getBalance());
        acct.withdraw(2500);
        System.out.println("Your account balance is:" + acct.getBalance());
        acct.deposit(3000);
        System.out.println("Your account balance is:" + acct.getBalance());

        System.out.println("Monthly interest rate is：" + (acct.getMonthlyInterest() * 100) +"%");




    }
}
