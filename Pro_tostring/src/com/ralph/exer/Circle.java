package com.ralph.exer;

public class Circle extends GeometricObject{
    private double radius;

    public Circle(){
        super();
        radius =1.0;
//        color = "w";
//        weight = 1.2;
    }

    public Circle(double radius){
        super();
        this.radius = radius;
    }

    public Circle(double radius,String color,double weight){
        super(color,weight);
        this.radius = radius;

    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double findArea(){
        return 3.14 * radius * radius;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return  true;
        }

        if (obj instanceof Circle){
            Circle c = (Circle)obj;
            return this.radius == c.radius;
        }
        return false;
    }
    @Override
    public String toString(){
        return "Circle [radius ="+ radius +"]";
    }

}
