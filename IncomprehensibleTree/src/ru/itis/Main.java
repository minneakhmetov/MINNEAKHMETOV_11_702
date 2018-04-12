package ru.itis;

public class Main {

    public static void main(String[] args) {
	Tree<Integer> tree = new Tree<>();
	Integer[] ints = {1, 3, 6, 8, 2, 5, 7, 9, 2, 5, 7};
	tree.convert(ints, 3);
	tree.print();
    }
}
