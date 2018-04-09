package ru.itis;

/**
 * 03.04.2018
 * TreeBstImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class TreeBstImpl<T extends Comparable<T>> implements Tree<T> {
    class Node {
        private T value;
        private Node left;
        private Node right;

        Node(T value) {
            this.value = value;
        }

    }

    private Node root;

    public TreeBstImpl() {
        this.root = null;
    }

    public void insert(T value) {
        this.root = insert(root, value);
    }

    public void print() {
        print(root);
    }

    private void print(Node root) {
        if (root != null) {
            print(root.left);
            System.out.print(root.value + " ");
            print(root.right);
        }
    }

    private Node insert(Node root, T value) {
        if (root == null) {
            root = new Node(value);
        } else if (value.compareTo(root.value) <= 0) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    //TODO:
    public boolean remove(T value) {
        return false;
    }

    //TODO:
    public boolean contains(T value) {
        Node node = root;

        if (node == null)
            return false;

        while (node != null) {
            if (node.value.compareTo(value) == 0)
                return true;
            else if (node.value.compareTo(value) > 0)
                node = node.left;
            else
                node = node.right;
        }

        return false;
    }





    //TODO:
    @Override
    public void printByLevels() {

    }

    //TODO
    @Override
    public boolean isBst() {
        return false;
    }

    private boolean isBst(Node node){
        if(node.left == null)
        if (node.left.value.compareTo(node.value) <= 0);
        return false;
    }


    public boolean equals(TreeBstImpl tree) {
        Node node = tree.root;
        Node newNode = root;
        return equals(node, newNode);
    }

    private boolean equals(Node node, Node newNode) {
        try {
            if (node == null & newNode == null)
                return true;
            else if (node.value.compareTo(newNode.value) == 0)
                return equals(node.left, newNode.left) && equals(node.right, newNode.right);
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }
}
