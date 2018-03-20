package ru.itis;

import java.util.Scanner;



public class Main {
    static final double n = 6;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        double[] x = {100, 100+k, 230-k, 240+k, 300, 380-k};
        double[] y = {200+k, 312, 347, 495, 450+k, 603};

        double a = (n * sumXY(x, y) - sumX(x)*sumX(y))/(n*sumXKVADRAT(x) - sumX(x) * sumX(x));

        double b = (sumX(y)*sumXKVADRAT(x) - sumXY(x,y)*sumX(x))/(n*sumXKVADRAT(x) - sumX(x)*sumX(x));


        double r = Math.sqrt((sumcherta(y) - sumvolna(y, x, a, b))/sumcherta(y));
        System.out.println("КООФИЦИЕНТ А");
        System.out.println(a);
        System.out.println("КООФИЦИЕНТ B");
        System.out.println(b);
        System.out.println("R");
        System.out.println(r);

        for (double xx: x) {
            System.out.print(xx + " ");
        }
        System.out.println(" ");

        for (double xx: y) {
            System.out.print(xx + " ");
        }

    }

    public static double sumXY (double[] x, double[] y){
        double sum = 0;
        for (int i = 0; i< n; i++)
            sum += x[i] * y[i];
        return sum;
    }

    public static double sumX (double[] x){
        double sum = 0;
        for (int i = 0; i< n; i++)
            sum += x[i];
        return sum;
    }

    public static double sumXKVADRAT (double[] x){
        double sum = 0;
        for (int i = 0; i< n; i++)
            sum += x[i] * x[i];
        return sum;
    }

    public static double sumvolna (double[] y, double[] x, double a, double b) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (y[i] - a*x[i] - b)*(y[i] - a*x[i] - b);
        }
        return sum;
    }

    public static double sumcherta (double[] y) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (y[i] - sumX(y)/6)*(y[i] - sumX(y)/6);
        }
        return sum;
    }

}
