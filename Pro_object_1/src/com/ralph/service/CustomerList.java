package com.ralph.service;

import com.ralph.bean.Customer;


public class CustomerList {
    private Customer[] Customers;
    private int total;

    /**
     * description： Specify the maximum space of the array
     * param totalCustomer :Specify the length of the array
     */
    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    /**
     * Description: Add the specified customer to the array
     * param:       customer
     * return:      true: Added successfully  false: Add failed
     */
    public boolean addCustomer(Customer customer) {
        if (total >= customers.length) {
            return false;
        }
        customers[total++] = customer;
        return true;
    }

    /**
     * Description: Modify customer information at the specified index location
     * param:       index
     * param:       cust
     * return:      true: modify successfully  false: modify failed
     */
    public boolean replaceCustomer(int index, Customer cust) {

        if (index < 0 || index >= total) {
            return false;
        }

        customers[index] = cust;
        return true;

    }

    /**
     * Description: Delete the customer at the specified index position
     * param:       index
     * return:      true: delete successfully  false: delete failed
     */
    public boolean deleteCustomer(int index) {
        if (index < 0 || index >= total) {
            return false;
        }
        for (int i = index; i < total - 1; i++) {
            customers[i] = customers[i + 1];
        }

        customers[--total] = null;
        return true;

    }

    /**
     * Description: Get all customer information
     * param:
     * return:
     */

    public Customer[] getAllCustomers() {
        Customer[] custs = new Customer[total];
        for (int i = 0; i < total; i++) {
            custs[i] = customers[i];
        }
        return custs;

    }


    /**
     * Description: Get customers at the specified index position
     * param:       index
     * return:
     */

    public Customer getCustomer(int index) {
        if (index < 0 || index >= total) {
            return null;
        }

        return customers[index];
    }

    public int getTotal() {
        return total;

    }
}