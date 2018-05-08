package ru.itis;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       Optimizator optimizator = new Optimizator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("kolichestvo chisel");
        int size = scanner.nextInt();

        System.out.println("k");
        int k = scanner.nextInt();

        int[] parents = new int[size - 1];

        for (int i = 0; i < parents.length; i++) {
            System.out.println("Вершина " + (i + 1) + " Водитель  ");
            parents[i] = scanner.nextInt();
        }

        System.out.println("Квадраты " + optimizator.resulting(parents, size, k));


        System.out.println(optimizator);

    }

}
