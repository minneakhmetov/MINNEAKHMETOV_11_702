package ru.itis;

public class Main {

    public static void main(String[] args) {
        int power = 4;
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] array1 = new int[array.length];


        for (int k = 1; k<power; k++){
            for(int i = 0; i<array.length; i++) {
                array1[i] = (int) Math.pow(array[i], k);
                System.out.println(array1[i]);
            }
        }

    }
}
