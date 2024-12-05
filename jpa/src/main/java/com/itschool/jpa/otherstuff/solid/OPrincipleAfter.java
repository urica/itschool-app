package com.itschool.jpa.otherstuff.solid;

public class OPrincipleAfter {
    public static void main(String... a) {
        ModernDrawingService service = new ModernDrawingService();

        Shape circle = new Circle(10, 10);
        Shape rectangle = new Rectangle(5, 10);

        service.drawShape(circle);
        service.drawShape(rectangle);
    }
}

interface Shape {
    void draw();

    int getX();

    int getY();
}

class Circle implements Shape {
    private int x;
    private int y;

    public Circle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle at(" + x + ", " + y + ")");
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}

class Rectangle implements Shape {
    private int x;
    private int y;

    public Rectangle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle at(" + x + ", " + y + ")");
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}

class ModernDrawingService {
    public void drawShape(Shape shape) {
        shape.draw();
    }
}