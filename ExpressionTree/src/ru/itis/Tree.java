package ru.itis;

import java.util.ArrayList;

public class Tree {

    Node root;
    private char[] charsArray;

    public void add(String string) throws SyntaxException{
        charsArray = string.toCharArray();
        root = new Node();
        try {
            add(root, 0);
        } catch (Exception e){
            throw new SyntaxException();
        }

    }

    private void add(Node current, int i) throws SyntaxException {
        if (i >= charsArray.length) return;

        if (charsArray[i] == '(') {
            current.left = new Node();
            current.left.parent = current;
            add(current.left, ++i);

        } else if (charsArray[i] == '+' || charsArray[i] == '-' || charsArray[i] == '*' || charsArray[i] == '/') {
            current.setValue("" + charsArray[i]);
            current.right = new Node();
            current.right.parent = current;
            add(current.right, ++i);

        } else if (charsArray[i] >= '0' && charsArray[i] <= '9') {
            for(;charsArray[i] >= '0' && charsArray[i] <= '9'; i++)
                current.setValue(current.getValue() + charsArray[i]);
            add(current.parent, i);

        } else if (charsArray[i] == ')') {
            if (charsArray.length - i <= 1) return;
            add(current.parent, ++i);

        } else if(charsArray[i] == ' '){
            add(current, ++i);

        } else {
            throw new SyntaxException();
        }
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

    ArrayList<ArrayList<String>> levels;
    public void printByLevels() {
        levels =  new ArrayList<>();
        levels(root, 0);
        for (int i = 0; i < levels.size(); i++) {
            String sLevel = "";
            for (int j = 0; j < levels.get(i).size(); j++) {
                sLevel += String.valueOf(levels.get(i).get(j)) + " ";
            }
            System.out.println(sLevel);
        }
    }

    private void levels(Node node, int level) {
        if (node != null) {
            if (!levels.contains(level)) levels.add(new ArrayList<String>());
            levels.get(level).add(node.getValue());
            level++;
            levels(node.left, level);
            levels(node.right, level);
        }
    }

    public void insert(Node node, Node parent){
        if (parent != null){
        if(parent.left == null) {
            parent.left = node;
            return;
        } if (parent.right == null) {
                parent.right = node;
                return;
            }
        } else {
            root = node;
            return;
        }
    }

    public boolean equals(Tree tree) {
        Node node = tree.root;
        Node newNode = root;
        return equals(node, newNode);
    }

    private boolean equals(Node node, Node newNode) {
        try {
            if (node == null & newNode == null)
                return true;
            else if (node.getValue().compareTo(newNode.getValue()) == 0)
                return equals(node.left, newNode.left) && equals(node.right, newNode.right);
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }


}
