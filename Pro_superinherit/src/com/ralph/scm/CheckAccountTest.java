package com.ralph.scm;

public class CheckAccountTest {	public static void main(String[] args) {

    CheckAccount acct = new CheckAccount(1122, 20000, 0.045, 5000);

    acct.withdraw(5000);
    System.out.println("Your account balance is ：" + acct.getBalance());
    System.out.println("Your overdraft limit is：" + acct.getOverdraft());
    acct.withdraw(18000);
    System.out.println("Your account balance is ：" + acct.getBalance());
    System.out.println("Your overdraft limit is：" + acct.getOverdraft());
    acct.withdraw(3000);
    System.out.println("Your account balance is ：" + acct.getBalance());
    System.out.println("Your overdraft limit is：" + acct.getOverdraft());


}
}
