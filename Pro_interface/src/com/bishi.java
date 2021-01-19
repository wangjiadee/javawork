package com;

public class bishi {


}


interface A{
    int x = 0;
}

class B{
    int x2 = 2;
}

class C extends B implements A{
    public void putx(){
        System.out.println(x);
    }

    public static void main(String[] args) {
        new C().putx();
    }
}