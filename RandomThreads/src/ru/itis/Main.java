package ru.itis;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random(System.currentTimeMillis());
        Scanner scanner = new Scanner(System.in);

        System.out.println("количечтов чисел");
        var n = scanner.nextInt();
        System.out.println("колчесвто потоков y");
        var k = scanner.nextInt();

        int array[] = new int[n];
        var sum = 0;
        var time = System.nanoTime();

        for(int i = 0; i < array.length; i++){
            array[i] = rnd.nextInt(1001);
            sum += array[i];
        }

        time = System.nanoTime() - time;
        System.out.println("Посчитано циклом:  " + sum + "      Время: " + time);

        int arrays[][] = new int[k][];

        for (int i = 0; i < arrays.length; i++)
            arrays[i] = new int[n/k];
        arrays[k-1] = new int[n/k + n%k];

        var position = 0;

        for (int i = 0; i < arrays.length; i++){
            for(int j = 0; j < arrays[i].length; j++) {
                arrays[i][j] = array[position];
                position++;
            }
        }

        time = System.nanoTime();
        NewThread threads[] = new NewThread[k];

        for(int i = 0; i < threads.length; i++){
            threads[i] = new NewThread(arrays[i]);
            threads[i].run();
        }

        sum = 0;

        for(int i = 0; i < threads.length; i++){
            sum += threads[i].getSum();
        }

        time = System.nanoTime() - time;
        System.out.println("Посчитано потоком: " + sum + "      Время: " + time);
    }
}
