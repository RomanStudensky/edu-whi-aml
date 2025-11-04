package lesson4;

public class Circle extends Shape{
    double radius;
    public Circle(double radius){
        this.radius = radius;
    }

    public void calculateArea() {
        double area = Math.PI * radius * radius;
        System.out.println("Circle: " + String.format("%.2f", area));
    }
}
