package ru.itis;

public class Main {

    public static void main(String[] args) throws SyntaxException {
        Tree tree = new Tree();
        //String s1 = "(( 3+ 41) * (  9 + 1     )  ) ";

        //tree.add(s1);
        tree.insert(new Node("*"), null);
        tree.insert(new Node("+"), tree.root);
        tree.insert(new Node("+"), tree.root);
        tree.insert(new Node("3"), tree.root.left);
        tree.insert(new Node("41"), tree.root.left);
        tree.insert(new Node("9"), tree.root.right);
        tree.insert(new Node("1"), tree.root.right);

        tree.printByLevels();


    }
}
