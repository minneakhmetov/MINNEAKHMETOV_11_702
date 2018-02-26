package ru.itis;

public class Node {
    int x; int y; int value;

    Node next;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean equal(Node node) {
        if (x == node.getX() && y == node.getY())
            return true;
        return false;
    }
}
