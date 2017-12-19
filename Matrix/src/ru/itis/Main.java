package ru.itis;

public class Main {

    public static void main(String[] args) {
	MatrixImpl matrix = new MatrixImpl();
	matrix.set(1,1,1);
	matrix.set(1,1,2);
	matrix.set(1,1,3);
	matrix.set(1,1,4);
        System.out.println(matrix.get(1,1));
    }
}
