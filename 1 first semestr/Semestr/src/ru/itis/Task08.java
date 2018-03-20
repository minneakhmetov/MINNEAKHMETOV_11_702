package ru.itis;

import java.util.Scanner;

public class Task08 {
    public static void Task08() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первую координату и радиус");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int r1 = scanner.nextInt();
        System.out.println("Введите первую координату и радиус");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int r2 = scanner.nextInt();
        int sum = Math.abs((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
        if (sum > r2+r1) {
            System.out.println("NO");
        } else System.out.println("YES");
    }
}
