package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int x; int y;

        Scanner scanner = new Scanner(System.in);
        System.out.println("введите координаты начала");
        x = scanner.nextInt();
        y = scanner.nextInt();
        Point start = new Point(x,y);
        System.out.println("введите координаты конца");
        x = scanner.nextInt();
        y = scanner.nextInt();
        Point end = new Point(x,y);
        System.out.println("введите координаты точки");
        x = scanner.nextInt();
        y = scanner.nextInt();
        Point point = new Point(x,y);

        Point vector1 = new Point(end.getX() - start.getX(), end.getY() - start.getY());
        Point vector2 = new Point(point.getX() - start.getX(), point.getY() - start.getY());

        double area = vector1.getX()*vector2.getY() - vector2.getX()*vector1.getY();
        System.out.println(area);
        double length1 = Math.sqrt(vector1.getX()*vector1.getX() + vector1.getY()*vector1.getY());
        double length2 = Math.sqrt(vector2.getX()*vector2.getX() + vector2.getY()*vector2.getY());

        double sinus = area/length1*length2;


        if (sinus > 0)
            System.out.println("выше");
        else
            System.out.println("ниже");

        //System.out.println(Math.asin(sinus) * 360 / Math.PI);

    }
}
