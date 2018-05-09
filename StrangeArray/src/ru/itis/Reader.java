package ru.itis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Reader {
    int edges = 0;
    int vertexes = 0;

    final int TWO = 2;

    String path = "C:\\Users\\razil\\Desktop\\StrangeArray\\src\\ru\\itis\\FILE.TXT";

    public int[][] read() {

        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNext()) {
                scanner.nextLine();
                edges++;
            }
        } catch (IOException e) {
        }

        int ints[][] = new int[edges][];

        try {
            Scanner scanner = new Scanner(new File(path));
            int i = 0;
            while (scanner.hasNext()) {
                ints[i] = new int[TWO];

                for (int j = 0; j < TWO; j++) {
                    ints[i][j] = scanner.nextInt();
                    if (ints[i][j] > vertexes)
                        vertexes = ints[i][j];
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        vertexes++;
        return ints;
    }
}
