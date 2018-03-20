package ru.itis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


class MyScanner {

    private FileInputStream input = new FileInputStream("src/input.txt");

    public MyScanner() throws FileNotFoundException {

    }

    public String nextLine() throws Exception {
        byte bytes[] = new byte[100];

        int length = input.read(bytes);
        String string = "";
        for (int i = 0; i < length; i++) {
            string += (char) bytes[i];
        }
        return string;
    }

    public int nextInt() throws Exception {
        byte bytes[] = new byte[100];

        int length = input.read(bytes);
        int number = 0;

        for (int i = 0; i < length; i++) {
            number *= 10;
            number += bytes[i] - '0';
        }
        return number;
    }

}