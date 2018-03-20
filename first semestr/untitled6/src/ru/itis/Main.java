package ru.itis;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strings[] = new String[5];
        boolean flag = false;
        for (int i = 0; i <strings.length; i++){
            strings[i] = scanner.nextLine();
        }
        for (int i = 0; i < strings.length; i++) {
             char chars[] = strings[i].toCharArray();

             flag = flag | isSorted(chars);
        }
        if (flag) {
            System.out.println("Есть строка");
        } else {
            System.out.println("Нет строки");
        }

    }

    public static boolean isSorted(char c[]) {
        boolean flag = true;
        int k = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u') {
                k++;
            }
        }
        for (int i = 0; i < c.length - 1; i++) {
            if (c[i] <= c[i + 1]) {
                flag &= true;
            } else flag &= false;
        }
        if (k > 1)
            return flag;
        else return false;
    }
}
