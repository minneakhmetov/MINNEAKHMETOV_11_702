package ru.itis;
import java.util.Scanner;

public class Task01 {
    public static void Task01() {

        Scanner scanner = new Scanner(System.in);
        String add = scanner.nextLine();
        int letter = add.charAt(0) - 'A' + 1;
        int number = add.charAt(1) - '0';

        if (letter % 2 == 1 && number % 2 == 1){
            System.out.println("BLACK");
        }
        if (letter % 2 == 0 && number % 2 == 0){
            System.out.println("BLACK");
        }
        if (letter % 2 == 1 && number % 2 == 0){
            System.out.println("WHITE");
        }
        if (letter % 2 == 0 && number % 2 == 1){
            System.out.println("WHITE");
        }
    }
}
