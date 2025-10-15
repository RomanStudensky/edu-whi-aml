public class Test {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(4.0, 6.0);
        rectangle.calculateArea();

        Shape circle = new Circle(5.0);
        circle.calculateArea();
    }
}

abstract class Shape {
    abstract void calculateArea();
}

class Rectangle extends Shape{
    double width;
    double height;
    Rectangle(double width, double height){
        this.height = height;
        this.width = width;
    }

    void calculateArea() {
        double area = width * height;
        System.out.println("Rectangle: " + String.format("%.2f", area));
    }
}

class Circle extends Shape{
    double radius;
    Circle(double radius){
        this.radius = radius;
    }

    void calculateArea() {
        double area = Math.PI * radius * radius;
        System.out.println("Circle: " + String.format("%.2f", area));
    }
}

