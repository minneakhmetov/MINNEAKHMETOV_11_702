package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        char[] letters = string.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            letters[i] -= '0';
        }
        for (int i = 0; i < letters.length/2; i++){
            char c = letters[i];
            letters[i] = letters[letters.length - i-1];
            letters[letters.length - i-1] = c;
        }

        int sum = 0; int c = 0;
        for (int k = 0; k < letters.length - 1; k++) {
            c++;
            int end = letters[letters.length - c];
            int count = 0;
            for (int i = 0; i < letters.length - c; i++) {
                if (letters[i] > end) count++;
            }
            sum += factorial(letters.length - c) * count;
        }
        System.out.println(sum);
    }
    public static int factorial(int num) {
        int fact = 1;
        for (; num > 0; fact *= num--);
        return fact;
    }
}
