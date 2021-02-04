package com.java.ralph;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class AVGrils implements Comparable {
    private String name;
    private double Size;

    public AVGrils(String name, double size) {
        this.name = name;
        Size = size;
    }
    public AVGrils(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSize() {
        return Size;
    }

    public void setSize(double size) {
        Size = size;
    }

    @Override
    public String toString() {
        return "AVGrils{" +
                "name='" + name + '\'' +
                ", Size='" + Size + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof AVGrils){
            AVGrils avGrils = (AVGrils)o;
            if (this.Size > avGrils.Size){
                return 1;
            }else if (this.Size < avGrils.Size){
                return -1;
            }else {
                return -this.name.compareTo(avGrils.name);

            }
        }
        throw new RuntimeException("ERROR!");
    }
}
