package ru.itis;

public class Main {

    public static void main(String[] args) {
		LinkedMatrix matrix = new LinkedMatrix();
		matrix.insert(0, 0, 2);
		matrix.insert(0, 1, 1);
		//matrix.insert(1, 0, 3);
		matrix.insert(1 ,1, 4);

		matrix.print();
		System.out.println("");
		System.out.println(matrix.sizeX(1));
		//matrix.transp();
		//matrix.insert(1, 1,3);
		//matrix.insert(1,0,4);
		//matrix.insert(3,3,3);
		//matrix.print();
		//System.out.println("");
		//matrix.sumCols(0, 1);
		//matrix.print();
		//matrix.delete(1,1);
		//matrix.print();
		//System.out.println(matrix.sumDiag());
		//int[][] matrix = {{1,2}, {3,4}};
		//	linkedMatrix = linkedMatrix.MatrixCode(matrix);
		matrix.print();


	}
}
