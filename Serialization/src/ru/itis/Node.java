package ru.itis;

public class Node<X, Y, V> {

    private X x;
    private Y y;
    private V value;
    public Node next;
    public Node prev;

    public Node(X x, Y y, V value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
    public X getX() {
        return x;
    }

    public void setX(X x) {
        this.x = x;
    }

    public Y getY() {
        return y;
    }

    public void setY(Y y) {
        this.y = y;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
