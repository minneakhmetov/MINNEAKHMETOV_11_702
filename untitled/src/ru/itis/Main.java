package ru.itis;

public class Main {

    public static void main(String[] args) {
        int i = 0;
        for (;; i++)
            if (i > 5) break;
            else System.out.println(i);
    }
}
