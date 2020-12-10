package com.ralph.java;

public class KidsTest {
    public static void main(String[] args) {
        Kids somek = new Kids(12);

        somek.printAge();

        somek.setSalary(0);
        somek.setSex(1);

        somek.employeed();
        somek.manOrWoman();
    }
}
