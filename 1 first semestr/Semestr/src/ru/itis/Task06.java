package ru.itis;

import java.util.Scanner;

public class Task06 {
    public static void Task06() {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        if (year % 4 == 0 && year % 100 != 100 || year % 400 == 0) {
            System.out.println("12.09." + year);
        } else {
            System.out.println("13.09." + year);
        }

    }
}
