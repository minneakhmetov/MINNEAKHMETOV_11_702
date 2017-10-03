package ru.itis;
import java.util.Scanner;

public class Main {
    public static double func(double x) {
        return Math.sin(x) - x - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = 0; int i =0;
        double a = -3;
        double b = -1;
        while (Math.abs(a-b) > 0.0001 ) {
            x = (a + b) / 2;
            if (func(x) > 0) {
                a = x;
            } else {
                b = x;
            }
            i++;
        }
        System.out.print(x + " " + i);
    }
}

