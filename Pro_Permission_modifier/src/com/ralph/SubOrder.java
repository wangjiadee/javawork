package com.ralph;
import org.ralph.Order;
public class SubOrder extends Order{
    public  void method() {
        orderProtected =1;
        orderPublic =2;

        methodProtected();
        methodPublic();
    }
}
