/*
* Define a class PassObject, define a method printAreas() in the class,
* @params: c     Circle class  
* @params: time  int types of max radius
*
*/

public class PassObject {
	
	public static void main(String[] args) {
        PassObject pt = new PassObject();

        Circle c = new Circle();

        pt.printAreas(c, 10);

        System.out.println("Radius:" + c.radius);
    }

    public void printAreas(Circle c, int time) {
        System.out.println("Radius\t\tArea");
        int i =1;
        for(;i <= time;i++){
            c.radius = i;
            double area = c.findArea();
            System.out.println(c.radius + "\t\t" + area);
        }
        c.radius = i;
    }
}