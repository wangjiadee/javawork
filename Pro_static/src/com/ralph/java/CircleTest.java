public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle();
        Circle c3 = new Circle(55.4);
        Circle c4 = new Circle(22.6);
        System.out.println(c1.getId());
        System.out.println(c2.getId());
        System.out.println(c3.getId());
        System.out.println(c4.getId());
        System.out.println(Circle.getTotal());
    }
}

class Circle{
    private double radius;
    private int id;

    public Circle(){
        id = init++;
        total++;
    }

    public Circle(double radius){
        this();
        this.radius = radius;
//        id = init++;
//        total++;

    }

    private static int total;
    private static int init = 1010;

    public double findArea(){
        return 3.14 * radius * radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public int getId() {
        return id;
    }

    public static int getTotal() {
        return total;
    }


}
