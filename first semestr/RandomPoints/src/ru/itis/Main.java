package ru.itis;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    Random rnd = new Random(System.currentTimeMillis());
    public ArrayList<Point> points = new ArrayList();

    public static void main(String[] args) {
        Random random = new Random(System.currentTimeMillis());
        Main main = new Main();
        for (int i = 0; i < random.nextInt(50); i++)
            main.addPoint();
        main.print();

    }

    public void addPoint() {
        int x = -10 + rnd.nextInt(20);
        //System.out.println(x);
        int y = -10 + rnd.nextInt(20);
        Point point = new Point(x, y);
        boolean flag = false;
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).equals(point)) {
                flag = true;
                break;
            }
        }
            if (flag) addPoint();
            else {
                points.add(point);
                printToFile(point);
            }

    }

    public void print() {
        for (int i = 0; i < points.size(); i++) {
            System.out.println("x = " + points.get(i).getX() + "; y = " + points.get(i).getY());
        }
    }

    public void printToFile(Point point) {
        try (FileWriter writer = new FileWriter("output.txt", true)) {
            // запись всей строки

            writer.write("x = " + point.getX() + "; y = " + point.getY());

            writer.append('\n');

            writer.flush();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}