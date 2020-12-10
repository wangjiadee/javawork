package com.ralph.ui;

import com.ralph.service.CustomerList;
import com.ralph.bean.Customer;
import com.ralph.util.CMUtility;
public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    public void enterMainMenu(){
        System.out.println("\n-----------------客户信息管理软件-----------------\n");
        System.out.println("                   1 添 加 客 户");
        System.out.println("                   2 修 改 客 户");
        System.out.println("                   3 删 除 客 户");
        System.out.println("                   4 客 户 列 表");
        System.out.println("                   5 退       出\n");
        System.out.print("                   请选择(1-5)：");
    }



    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }

}