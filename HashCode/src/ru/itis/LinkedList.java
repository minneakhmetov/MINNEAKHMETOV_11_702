package ru.itis;

public class LinkedList<K, V> implements List<K, V> {

    Node head;
    Node tail;


    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    class Node {
        K key;
        V value;
        Node next;

        Node(K key, V val) {
            this.key = key;
            this.value = val;
        }
    }



    @Override
    public void add(K key, V value) {
        Node newNode = new Node(key, value);
        if (head == null) {
            head  = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    @Override
    public V get(K key) {
        Node newNode = this.head;

        while (newNode != null) {
            if (newNode.key.equals(key))
                return newNode.value;
            newNode = newNode.next;
        }
        return null;
    }

    public Node get(int index){
        int i = 0;
        Node newNode = head;
        while (i < index){
            newNode = newNode.next;
            i++;
        }
        return newNode;
    }

    public int size(){
        int count = 0;
        Node newNode = this.head;
        while (newNode != null)
            count++;
        return count;
    }
}
