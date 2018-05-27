package ru.itis;

public class Node {

    Node left;
    Node right;
    Node parent;
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
