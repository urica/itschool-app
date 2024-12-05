package com.itschool.jpa.otherstuff.solid;

public class LPrincipleBefore {
    public static void main(String[] a) {
        Rectangle1 r = new Rectangle1(0, 0, 4, 5);
        r.setWidth(10);
        r.setHeight(20);
        System.out.println("Arie: " + r.getArea());

        Rectangle1 r2 = new Square(0, 0, 4);
        r2.setWidth(10);
        r2.setHeight(20);
        System.out.println("Arie: " + r2.getArea());
    }
}

abstract class Shape1 {
    protected int x;
    protected int y;

    public Shape1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract void resize(int x, int y);

}

class Rectangle1 extends Shape1 {
    protected int width;
    protected int height;

    public Rectangle1(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int w) {
        this.width = w;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public void resize(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Square extends Rectangle1 {
    public Square(int x, int y, int size) {
        super(x, y, size, size);
    }

    @Override
    public void setHeight(int h) {
        setSize(h);
    }

    @Override
    public void setWidth(int w) {
        setSize(w);
    }

    private void setSize(int size) {
        super.setHeight(size);
        super.setWidth(size);
    }

}