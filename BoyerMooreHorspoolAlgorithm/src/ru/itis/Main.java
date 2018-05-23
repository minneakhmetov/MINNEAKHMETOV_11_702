package ru.itis;

import java.util.Scanner;

public class Main {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {

        Finder finder = new Finder();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку");
        String string = scanner.nextLine();
        System.out.println("Введите слово");
        String word = scanner.nextLine();

        finder.shiftArrayCreating(word);
        System.out.println("Массив сдвигов");
        for(int i = 0; i < finder.d.length; i++)
            System.out.print(finder.d[i] + " ");
        System.out.println();

        int i = finder.find(string, word);
        System.out.println(string.substring(0, i+1) + ANSI_RED + string.substring(i+1, i + word.length() + 1) + ANSI_RESET + string.substring(i + word.length() + 1) );






    }
}
