package ru.itis;

import java.util.ArrayList;
import java.util.LinkedList;

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
        private Node parent;

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
            root.left.parent = root;
        } else {
            root.right = insert(root.right, value);
            root.right.parent = root;
        }
        return root;
    }

    //TODO:
    public boolean remove(T value) {
        Node node = find(value);
        Node parent = node.parent;                                 // предок удаляемого элемента
        if (node.left == null & node.right == null) {       // первый случай: удаляемый элемент - лист
            if (parent.left == node)
                parent.left = null;
            if (parent.right == node)
                parent.right = null;
            return true;
        } else if (node.left == null | node.right == null)     // второй случай: удаляемый элемент имеет одного потомка
            if (node.left == null) {
                if (parent.left == node)
                    parent.left = node.right;
                else
                    parent.right = node.right;
                node.right.parent = parent;
            } else {
                if (parent.left == node)
                    parent.left = node.left;
                else
                    parent.right = node.left;
                node.left.parent = parent;
                return true;
            }
        else {                                        // третий случай: удаляемый элемент имеет двух потомков
            Node successor = next(node);
            node.value = successor.value;
            if (successor.parent.left == successor) {
                successor.parent.left = successor.right;
                if (successor.right != null)
                    successor.right.parent = successor.parent;
            } else {
                successor.parent.right = successor.right;
                if (successor.right != null)
                    successor.right.parent = successor.parent;
            }
            return true;
        }
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
        printByLevels(root);

    }

    int capacity = 1;
    LinkedList<ArrayList> list = new LinkedList();

    private void printByLevels(Node node) {
        ArrayList<T> arr = new ArrayList<>();
        arr.add(node.value);
        list.add(arr);
        list.add(printEachLevel(node));
        iDoNotKnowHowToNameThisMethod(root);

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++)
                System.out.print(list.get(i).get(j) + " ");
            System.out.println();
        }


    }

    private void iDoNotKnowHowToNameThisMethod(Node node) {
        try {
            list.add(merge(printEachLevel(node.left), printEachLevel(node.right)));
            iDoNotKnowHowToNameThisMethod(node.right);
            iDoNotKnowHowToNameThisMethod(node.left);
        } catch (NullPointerException e) {

        }
    }

    private ArrayList<T> merge(ArrayList<T> a, ArrayList<T> b) {
        ArrayList<T> arrayList = new ArrayList();
        for (int i = 0; i < a.size(); i++)
            arrayList.add(a.get(i));
        for (int i = 0; i < b.size(); i++)
            arrayList.add(b.get(i));
        return arrayList;
    }

    private ArrayList printEachLevel(Node node) {
        ArrayList<T> arrayList = new ArrayList();
        arrayList.add(node.left.value);
        arrayList.add(node.right.value);
        return arrayList;
    }

    ArrayList<ArrayList<T>> levels;

    @Override
    public void printByLevels2() {
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
            if (!levels.contains(level)) levels.add(new ArrayList<T>());
            levels.get(level).add(node.value);
            level++;
            levels(node.left, level);
            levels(node.right, level);
        }
    }



    //TODO
    @Override
    public boolean isBst() {
        return isBst(root);
    }

    private boolean isBst(Node node) {
        if (node != null) {
            if ((node.left != null && node.value.compareTo(node.left.value) < 0) || (node.right != null && node.value.compareTo(node.right.value) >= 0)) {
                return false;
            } else {
                isBst(node.left);
                isBst(node.right);
            }
        }
        return true;
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

    private Node find(T value) {
        Node node = root;
        while (node != null) {
            if (node.value.compareTo(value) == 0)
                return node;
            if (node.value.compareTo(value) > 0)
                node = node.left;
            else node = node.right;
        }
        return null;
    }

    private Node next(Node node) {
        if (node.right != null)
            return minimum(node.right);
        Node y = node.parent;
        while (y != null & node == y.right) {
            node = y;
            y = y.parent;
        }
        return y;
    }

    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }


}
