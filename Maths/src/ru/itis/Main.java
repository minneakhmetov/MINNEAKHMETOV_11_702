package ru.itis;

public class Main {

    public static void main(String[] args) {
	final double min = 0;
	final double max = 2 * Math.PI;
	final int split = 20;
	double step = (max - min)/split;
	double sum = 0;

	for(int i = 1; i < split; i++){
	    sum += i*step*(function(i*step) + function((i+1)*step))/2;
    }
        System.out.println(sum);

    }

    public static double function(double x){
        return (2+ Math.cos(x))*(3+Math.cos(x));

    }
}

