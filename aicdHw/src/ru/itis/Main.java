package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Vvedite pervoe chislo");
        String num1 = scanner.nextLine();
        System.out.println("Vvedite vtoroe chislo");
        String num2 = scanner.nextLine();
        char[] num1Array = num1.toCharArray();
        char[] num2Array = num2.toCharArray();
        for (int i = 0; i < num1Array.length; i++)
            num1Array[i] -= '0';
        for (int i = 0; i < num2Array.length; i++)
            num2Array[i] -= '0';
        int[] num1Arr = new int[num1Array.length];
        int[] num2Arr = new int[num2Array.length];
        for (int i = 0; i < num1Array.length; i++)
            num1Arr[i] = num1Array[i];
        for (int i = 0; i < num2Array.length; i++)
            num2Arr[i] = num2Array[i];

        if (num1Arr.length > num2Arr.length) {
            for (int i = num2Arr.length - 1; i > -1; i--) {
                int result = num1Arr[(num1Arr.length - num2Arr.length) + i] + num2Arr[i];
                if (result < 9) {
                    num1Arr[(num1Arr.length - num2Arr.length) + i] = result;
                } else {
                    num1Arr[(num1Arr.length - num2Arr.length) + i] = result - 10;
                    num1Arr[(num1Arr.length - num2Arr.length) + i - 1]++;
                }

            }
            for (int x : num1Arr)
                System.out.print(x);
        }

        if (num2Arr.length > num1Arr.length) {
            for (int i = num1Arr.length - 1; i > -1; i--) {
                int result = num2Arr[(num2Arr.length - num1Arr.length) + i] + num1Arr[i];
                if (result < 9) {
                    num2Arr[(num2Arr.length - num1Arr.length) + i] = result;
                } else {
                    num2Arr[(num2Arr.length - num1Arr.length) + i] = result - 10;
                    num2Arr[(num2Arr.length - num1Arr.length) + i - 1]++;
                }

            }
            for (int x : num2Arr)
                System.out.print(x);
        }

        if (num1Arr.length == num2Arr.length) {
            int[] numArr = new int[num1Arr.length + 1];

            for(int i = 0; i < num1Arr.length; i++) {
                numArr[i + 1] = num1Arr[i];
            }

            for (int i = num2Arr.length - 1; i > -1; i--) {
                int result = numArr[i+1] + num2Arr[i];
                if (result < 9) {
                    numArr[i+1] = result;
                } else {
                    numArr[i+1] = result - 10;
                    numArr[i]++;
                }
            }
            for (int i = 0; i < numArr.length; i++) {
                if (i == 0) {
                    if (numArr[i] != 0)
                    System.out.print(numArr[i]);
                } else
                    System.out.print(numArr[i]);
            }
        }
    }
}
