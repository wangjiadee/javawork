package org.ralph.exer;

public class GeometricTest {

    public static void main(String[] args) {
        GeometricTest test = new GeometricTest();
        Circle c1 = new Circle(2.3,"b",1.2);
        Circle c2 = new Circle(3.3,"w",2.2);
        MyRectangle r1 = new MyRectangle(1,2,"w",4);

        test.displayGeometricObject(c1);
        test.displayGeometricObject(c2);
        test.displayGeometricObject(r1);

        boolean isEquals = test.equalsArea(c1,c2);
        System.out.println(isEquals);
    }

    public void displayGeometricObject(GeometricObject o){//GeometricObject o = new Circle(...)
        System.out.println("The area is: " + o.findArea());
    }

    //测试两个对象的面积是否相等
    public boolean equalsArea(GeometricObject o1,GeometricObject o2){
        return o1.findArea() == o2.findArea();
    }
}
