package org.ralph;

public class Order {
    private int orderPrivate;
    int orderDefault;
    protected int orderProtected;
    public int orderPublic;

    private void methodprivate(){
        orderPrivate =111;
        orderDefault =222;
        orderProtected=333;
        orderPublic=444;
    }
    void methodDsfault(){
        orderPrivate =111;
        orderDefault =222;
        orderProtected=333;
        orderPublic=444;
    }
    protected void methodProtected(){
        orderPrivate =111;
        orderDefault =222;
        orderProtected=333;
        orderPublic=444;
    }
    public void methodPublic(){
        orderPrivate =111;
        orderDefault =222;
        orderProtected=333;
        orderPublic=444;
    }
}
