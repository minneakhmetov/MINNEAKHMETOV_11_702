package ru.itis;

public class Shape {

    int area;
    int perimeter;
    int a;
    int b;

    public Shape(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Shape() {

    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getArea() {
        return area;
    }

    public int getPerimeter() {
        return perimeter;
    }
}

