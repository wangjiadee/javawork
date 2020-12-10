/*
* Define a Circle class, including a double type radius 
* attribute representing the radius of the circle, A 
* findArea() method returns the area of ​​the circle.
* @param : radius 
* @return: Area of ​​the circle
*/
public class Circle{
    double radius;

    public double findArea() {
        return Math.PI * radius * radius;
    }
}