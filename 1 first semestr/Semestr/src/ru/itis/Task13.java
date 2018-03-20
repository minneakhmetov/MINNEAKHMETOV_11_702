package ru.itis;


import java.util.Scanner;

public class Task13 {
    public static void Task13() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int rebmun = 0;
        int x = number;
        for (int i = 0; i<6; i++){
            rebmun *= 10;
            rebmun += x % 10;
            x /= 10;
        }
        if (number == rebmun) {
            System.out.println("YES");
        } else
            System.out.println("NO");
    }
}
