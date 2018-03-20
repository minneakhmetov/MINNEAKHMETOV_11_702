package ru.itis;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileReader fin = new FileReader("input.txt");
        String name;
        int c;
        System.out.println("Print File Files.txt? y/n");
        name = br.readLine();
        if(name.equals("y"))
            while ((c = fin.read()) != -1) System.out.println((char) c);
    }
}