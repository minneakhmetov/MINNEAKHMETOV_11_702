package ru.itis;

public class Main {

    public static void main(String[] args) throws SyntaxException {
        Tree tree = new Tree();
        String s1 = "(( 3+ 41) * (  9 + 1     )  ) ";

        tree.add(s1);

        tree.printByLevels();


    }
}
