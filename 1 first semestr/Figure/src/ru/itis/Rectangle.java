package ru.itis;

public class Rectangle extends Shape {

    private int a;
    private int b;
   // area = a*b;
   // perimeter = (a+b)*2;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
        super.area = area();
        super.perimeter = perimeter();
    }

    public int area(){
        return a*b;
    }


    public int perimeter() {
        return (a+b)*2;
    }

}
