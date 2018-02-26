package ru.itis;

import java.util.Scanner;

public class Main {
    static int k;
    static Point[] points;
    static Point[] pointsResult;
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ведите количество точек");
        k = scanner.nextInt();

        points = new Point[k];
        pointsResult = new Point[k];

        for (int i = 0; i < k; i++) {
            System.out.println("введите точку");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points[i] = new Point(x, y);
        }

        Point min = new Point(9999, 9999);
        Point max = new Point(0, 0);
        for (int i = 0; i < k; i++) {
            if (points[i].getX() <= min.getX() & points[i].getY() <= min.getY())
                min = points[i];
            if (points[i].getX() >= max.getX() & points[i].getY() >= max.getY())
                max = points[i];

        }

        resuling(max, min);

        double maxBottom1 = 0;
        Point maxPoint1 = new Point(0 , 0);
        double maxBottom2 = 0;
        Point maxPoint2 = new Point (0, 0);

        for (int i = 0; i < k; i++) {
            if (isUp(min, max, points[i])) {
                double temp = triangle(min, max, points[i]);
                if (maxBottom1 <= temp) {
                    maxBottom1 = temp;
                    maxPoint1 = points[i];
                }
            } else {
                double temp = triangle(min, max, points[i]);
                if (maxBottom2 <= temp) {
                    maxBottom2 = temp;
                    maxPoint2 = points[i];
                }
            }
        }
        resuling(maxPoint1, maxPoint2);

        print();
    }

    public static void resuling(Point one, Point two) {
        for (int i = 0; i < k; i++){
            if(one.equals(points[i]) | two.equals(points[i])){
                points[i] = null;
                for(int j = i; i < k-1; i++)
                    points[j] = points[j+1];
                points[k-1] = null;
            }
        }
        k -= 2;
        pointsResult[count] = one;
        count++;
        pointsResult[count] = two;
        count++;
    }
    public static void print(){
        for(int i = 0; i < pointsResult.length; i++){
            System.out.println("X: " + pointsResult[i].getX() + "  Y: " + pointsResult[i].getY());
        }
    }

    public static boolean isUp(Point end, Point start, Point point) {

        Point vector1 = new Point(end.getX() - start.getX(), end.getY() - start.getY());
        Point vector2 = new Point(point.getX() - start.getX(), point.getY() - start.getY());

        double area = vector1.getX() * vector2.getY() - vector2.getX() * vector1.getY();

        double length1 = Math.sqrt(vector1.getX() * vector1.getX() + vector1.getY() * vector1.getY());
        double length2 = Math.sqrt(vector2.getX() * vector2.getX() + vector2.getY() * vector2.getY());

        double sinus = area / length1 * length2;

        return sinus > 0;
    }

    public static double triangle(Point bottom1, Point bottom2, Point up) {
        double a = Math.sqrt((bottom2.getX() - bottom1.getX()) * (bottom2.getX() - bottom1.getX()) + (bottom2.getY() - bottom1.getY()) * (bottom2.getY() - bottom1.getY()));
        double b = Math.sqrt((bottom2.getX() - up.getX()) * (bottom2.getX() - up.getX()) + (bottom2.getY() - up.getY()) * (bottom2.getY() - up.getY()));
        double c = Math.sqrt((bottom1.getX() - up.getX()) * (bottom1.getX() - up.getX()) + (bottom1.getY() - up.getY()) * (bottom1.getY() - up.getY()));
        double p = (a + b + c) / 2;
        return 2 * Math.sqrt(p * (p - a) * (p - b) * (p - c)) / a;
    }




}
