package com.ralph.exer;

public class GeometricObject {
    protected String color;
    protected double weight;

    protected GeometricObject(){
        super();
        this.color = "w";
        this.weight = 1.2;

    }

    protected GeometricObject(String color,double weight){
        super();
        this.color = color;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
