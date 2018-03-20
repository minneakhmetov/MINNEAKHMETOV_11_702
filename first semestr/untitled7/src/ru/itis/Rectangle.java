package ru.itis;

public class Rectangle {

    double x1;
    double y1;
    double x2;
    double y2;
    double x3;
    double y3;
    double x4;
    double y4;

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

    public double getX3() {
        return x3;
    }

    public double getY3() {
        return y3;
    }

    public double getX4() {
        return x4;
    }

    public double getY4() {
        return y4;
    }

    public Rectangle(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;
    }

    public void move(double x, double y){
        x1 += x;
        x2 += x;
        x3 += x;
        x4 += x;
        y1 += y;
        y2 += y;
        y3 += y;
        y4 += y;
    }
    public void change(int x, int y){
        x3 = x;
        y3 = y;
        y2 = y;
        x4 = x;
    }
    public Rectangle minRectangle (Rectangle rect1, Rectangle rect2){
        double a1, b1, a2, b2, a3, b3, a4, b4;
//        if (rect1.getY2() < rect2.getY2()) b2 = rect1.getY2();
//        if (rect1.getY2() > rect2.getY2()) b2 = rect2.getY2();
//        if (rect1.getY2() == rect2.getY2()) b2 = rect1.getY2();
//        a2 = a1 = rect2.getX1() - rect1.getX1();
//        a4 = rect1.getX4();
        a1 = rect2.getX1();
        b1 = rect2.getY1();
        a3 = rect1.getX3();
        b3 = rect1.getY3();
        b2 = rect1.getY2();
        a2 = rect2.getY2();
        a4 = rect1.getX4();
        b4 = rect2.getY4();
        Rectangle rect3 = new Rectangle(a1, b1, a2, b2, a3, b3, a4, b4);
        return rect3;

    }
    public void print(){
        System.out.println(x1 + " " + y1);
        System.out.println(x2 + " " + y2);
        System.out.println(x3 + " " + y3);
        System.out.println(x4 + " " + y4);
    }


}
