package ru.itis;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {

        double[] monthAverageDegree = new double[12];
        short[] dayCount = new short[12];
        double yearAverageDegree = 0;
        double minLambda = 999999;
        int days = 0;
        int minMonth = 0;


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int day = (line.charAt(0) - '0') * 10 + (line.charAt(1) - '0');
                //System.out.println(day);
                int month = (line.charAt(3) - '0') * 10 + (line.charAt(4) - '0');
                //System.out.println(month);
                double value = Double.valueOf(line.substring(6, line.length()));
                //System.out.println(value);
                yearAverageDegree += value;
                monthAverageDegree[month-1] += value;
                dayCount[month-1]++;
                days++;

            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        yearAverageDegree /= days;

        for(int i = 0; i < dayCount.length; i++) {
            monthAverageDegree[i] /= dayCount[i];
            if (Math.abs(yearAverageDegree-monthAverageDegree[i]) < minLambda) {
               // System.out.println(Math.abs(yearAverageDegree-monthAverageDegree[i]));
                minLambda = Math.abs(yearAverageDegree - monthAverageDegree[i]);
                minMonth = i;
            }
        }

        switch (minMonth) {
            case 0:
                System.out.println("Январь");
                break;
            case 1:
                System.out.println("Февраль");
                break;
            case 2:
                System.out.println("Март");
                break;
            case 3:
                System.out.println("Апрель");
                break;
            case 4:
                System.out.println("Май");
                break;
            case 5:
                System.out.println("Июнь");
                break;
            case 6:
                System.out.println("Июль");
                break;
            case 7:
                System.out.println("Август");
                break;
            case 8:
                System.out.println("Сентябрь");
                break;
            case 9:
                System.out.println("Октябрь");
                break;
            case 10:
                System.out.println("Ноябрь");
                break;
            case 11:
                System.out.println("Декабрь");
                break;
        }
    }
}


