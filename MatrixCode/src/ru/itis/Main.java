package ru.itis;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
		LinkedMatrix matrix = new LinkedMatrix();
		matrix.insert(0, 0, 1);
		matrix.insert(1, 1, 2);
		matrix.insert(0, 1, 3);
		matrix.insert(1, 0, 4);
		matrix.sumCols(0,1);
		//matrix.insert(1 ,1, 1);
		//matrix.insert(2,0,1);
		//matrix.insert(2, 1, 1);




		matrix.print();
		//System.out.println("");
		//System.out.println(matrix.sizeX(0));
		//System.out.println(matrix.sizeXMax());
		//System.out.println(matrix.sizeYMax());
		//int[][] intMatrix = matrix.decode();
//		for (int i = 0; i < intMatrix.length; i++) {
//			for (int j = 0; j < intMatrix[i].length; j++) {
//				System.out.print(intMatrix[i][j] + " ");
//			}
//			System.out.println("");
//		}
		//ArrayList<Integer> list = matrix.minList();

		//	for (int i = 0; i < list.size(); i++)
		//		System.out.println(list.get(i));

		//matrix.transp();
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
		//matrix.print();

	}
}
