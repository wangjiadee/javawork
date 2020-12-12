package com.ralph.scm;

public class CheckAccount extends Account {

    private double overdraft;//可透支限额

    //
    public CheckAccount(int id, double balance, double annualInterestRate,double overdraft){
        super(id, balance, annualInterestRate);
        this.overdraft = overdraft;

    }


    public double getOverdraft() {
        return overdraft;
    }


    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }


    @Override
    public void withdraw(double amount) {
        if(getBalance() >= amount){//余额就足够消费
//			getBalance() -= amount;
            //方式一：
//			setBalance(getBalance() - amount);
            //方式二：
            super.withdraw(amount);
        }else if(overdraft >= amount - getBalance()){//透支额度+余额足够消费

            overdraft -= (amount - getBalance());

//			setBalance(0);
            //或
            super.withdraw(getBalance());

        }else{
            System.out.println("Overdraft limit exceeded!");
        }
    }
}
