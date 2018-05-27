package ru.itis;

public class Tree {

    Node root;

    void add(Object value) {
        if (root == null) {
            root = new Node(value);
            return;
        }

        if (isOperator(value) & isInt(root.getValue())) {
            Node node = new Node(value);
            root.parent = node;
            node.left = root;
            root = node;
            return;
        }

        if(isInt(value) & isOperator(root.getValue())){
            Node node = new Node(value);
            root.right = node;
            return;
        }

        if(isOperator(value) & isOperator(root.getValue())){
            Node node = new Node(value);
            node.left = root;
            root = node;
            return;
        }
    }

    boolean isInt(Object obj) {
        try {
            int number = (Integer) obj;
            return true;
        } catch (ClassCastException e){
            return false;
        }
    }

    boolean isOperator(Object obj){
        if (obj.equals("+") || obj.equals("-") || obj.equals("*") || obj.equals("/"))
            return true;
        else return false;
    }

    public void print() {
        print(root);
    }

    private void print(Node root) {
        if (root != null) {
            print(root.left);
            System.out.print(root.getValue() + " ");
            print(root.right);
        }
    }


}
