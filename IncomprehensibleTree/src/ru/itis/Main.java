package ru.itis;

public class Main {

    public static void main(String[] args) {
	Tree<Integer> tree = new Tree<>();
	Integer[] ints = {1, 3, 6, 8, 2, 5, 7, 9, 2, 5, 7, 6, 8, 8, 3, 5, 6, 7, 9, 1, 3, 4, 5};
	tree.convert(ints, 3);
	tree.print();
	tree.squarePrint();

    }
}
