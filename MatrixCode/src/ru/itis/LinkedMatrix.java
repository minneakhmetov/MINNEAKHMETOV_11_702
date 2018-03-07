package ru.itis;

import java.util.ArrayList;

public class LinkedMatrix implements Matrix {

    // ссылка на первый элемент списка
    Node head;
    // ссылка на последний элемент списка
    Node tail;

    public LinkedMatrix() {
        this.head = null;
        this.tail = null;
    }

    public LinkedMatrix MatrixCode(int[][] matrix) {
        LinkedMatrix linkedMatrix = new LinkedMatrix();
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                if (matrix[i][j] != 0)
                    linkedMatrix.insert(i, j, matrix[i][j]);
        return linkedMatrix;
    }

    public int[][] decode() {
        int[][] newInt = new int[sizeXMax()][sizeYMax()];
        Node newNode = this.head;
        while (newNode != null) {
            newInt[newNode.getX()][newNode.getY()] = newNode.getValue();
            newNode = newNode.next;
        }
        return newInt;
    }

    public void insert(int x, int y, int value) {

        Node newNode = new Node(x, y);

        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.setValue(value);
        } else {
            Node node = this.head;
            while (node != null) {
                if (node.equal(newNode)) {
                    node.setValue(value);
                    return;
                }
                node = node.next;
            }

            tail.next = newNode;
            tail = newNode;
            tail.setValue(value);
        }
    }

    public void delete(int x, int y) {
        Node newNode = new Node(x, y);
        Node node = this.head;

        if (node.equal(newNode)) {
            head = node.next;
            return;
        }

        if (newNode.equal(tail)) {
            for (int i = 0; i < size() - 2; i++)
                node = node.next;
            node.next = null;
            tail = node;
            return;
        }

        node = this.head;
        Node prev = this.head;
        while (node != this.tail) {
            if (node.equal(newNode)) {
                prev.next = node.next;
                return;
            }
            prev = node;
            node = node.next;
        }


    }

    public ArrayList minList() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> ints = new ArrayList<>();

        Node newNode = this.head;
        while (newNode != null) {

            if (!ints.contains(newNode.getX())) {
                list.add(min(newNode.getX()));
                ints.add(newNode.getX());
            }
            newNode = newNode.next;
        }

        return list;
    }

    public int sumDiag() {
        int sum = 0;
        Node newNode = this.head;
        while (newNode != null) {
            if (newNode.getX() == newNode.getY()) {
                sum += newNode.getValue();
            }
            newNode = newNode.next;
        }
        return sum;
    }

    public void transp() {
        Node newNode = this.head;
        while (newNode != null) {
            int temp = newNode.getX();
            newNode.setX(newNode.getY());
            newNode.setY(temp);
            newNode = newNode.next;
        }
    }

    public void sumCols(int y1, int y2) {
        Node newNode = this.head;
        while (newNode != null) {
            if (newNode.getX() == y1) {
                Node node = this.head;
                while (node != null) {
                    if (node.getX() == y2 && newNode.getY() == node.getY())
                        newNode.setValue(newNode.getValue() + node.getValue());
                    node = node.next;
                }
            }
            newNode = newNode.next;
        }
    }

    public int size() {
        Node newNode = this.head;
        int count = 0;
        while (newNode != null) {
            count++;
            newNode = newNode.next;
        }
        return count;
    }

    public int sizeX(int x) {
        Node newNode = this.head;
        int count = 0;
        while (newNode != null) {
            if (newNode.getX() == x)
                count++;
            newNode = newNode.next;
        }
        return count;
    }

    public int sizeY(int y) {
        Node newNode = this.head;
        int count = 0;
        while (newNode != null) {
            if (newNode.getY() == y)
                count++;
            newNode = newNode.next;
        }
        return count;
    }

    public int sizeXMax() {
        Node newNode = this.head;
        int max = 0;
        while (newNode != null) {
            if (sizeX(newNode.getX()) >= max)
                max = sizeX(newNode.getX());
            newNode = newNode.next;
        }
        return max;
    }

    public int sizeYMax() {
        Node newNode = this.head;
        int max = 0;
        while (newNode != null) {
            if (sizeY(newNode.getY()) >= max)
                max = sizeY(newNode.getY());
            newNode = newNode.next;
        }
        return max;
    }
    public int min(int x){
        Node newNode = this.head;
        int min = 9999;
        while(newNode != null){
            if (newNode.getX() == x){
                if (newNode.getValue() < min)
                    min = newNode.getValue();
            }
            newNode = newNode.next;
        }
        return min;
    }

    public void print() {
        Node newNode = this.head;
        while (newNode != null) {
            System.out.println("X: " + newNode.getX() + "  Y: " + newNode.getY() + "  Value: " + newNode.getValue());
            newNode = newNode.next;
        }
    }

}
