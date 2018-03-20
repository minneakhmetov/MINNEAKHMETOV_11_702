package ru.itis;

import java.util.Scanner;

public class Task16 {
    public static void Task16(){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int sum1 = 0;
        int sum2 = 0;
        for (int i=0; i<3; i++){
            sum1 += number % 10;
            number /= 10 ;
        }
        for (int i=0; i<3; i++){
            sum2 += number % 10;
            number /= 10;
        }
        if (Math.abs(sum1-sum2) == 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
