package ru.itis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    final static boolean one = false;
    final static boolean two = true;

    public static void main(String[] args) {
        File file = new File("C:/Users/razil/Desktop");
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++)
            System.out.println(files[i]);

        File file1 = new File("C:\\Users\\razil\\Desktop\\lox.txt");
        file1.delete();

    }
}
