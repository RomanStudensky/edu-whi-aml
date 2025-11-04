package lesson4;

public class Rectangle extends Shape{
    double width;
    double height;
    public Rectangle(double width, double height){
        this.height = height;
        this.width = width;
    }

    public void calculateArea() {
        double area = width * height;
        System.out.println("Rectangle: " + String.format("%.2f", area));
    }
}
