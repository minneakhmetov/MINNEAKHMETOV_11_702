package ru.itis;

import java.util.Scanner;

public class Task10 {
    public static void Task10() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        double d = b*b - 4*a*c;
        if (d<0) {
            System.out.println("-1");
        } else
            if (d == 0) {
                System.out.println("Корень:" + ((-b)/2*a));
            } else {
            double x1 = (-b-Math.sqrt(d))/2*a;
            double x2 = (-b+Math.sqrt(d))/2*a;
            System.out.println("Корни" + x1 + " " + x2);
            }
    }
}
