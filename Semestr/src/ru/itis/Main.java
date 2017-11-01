package ru.itis;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите номер проги");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1:
                Task01.Task01();
                break;
            case 2:
                Task02.Task02();
                break;
            case 3:
                Task03.Task03();
                break;
            case 4:
                Task04.Task04();
                break;
            case 5:
                Task05.Task05();
                break;
            case 6:
                Task06.Task06();
                break;
            case 7:
                Task07.Task07();
                break;
            case 8:
                Task08.Task08();
                break;
            case 9:
                Task09.Task09();
                break;
            case 10:
                Task10.Task10();
                break;
            case 11:
                Task11.Task11();
                break;
            case 12:
                Task12.Task12();
                break;
            case 13:
                Task13.Task13();
                break;
            case 14:
                Task14.Task14();
                break;
            case 15:
                Task15.Task15();
                break;
            case 16:
                Task16.Task16();
                break;
            case 17:
                Task17.Task17();
                break;
            case 18:
                Task18.Task18();
                break;
            case 19:
                Task19.Task19();
                break;
            case 20:
                Task20.Task20();
                break;


        }
    }
}
