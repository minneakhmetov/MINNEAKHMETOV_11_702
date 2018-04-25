package ru.itis;

public class Hash<K, V> implements Map<K, V> {

    final int size = 16;

    Node<K, V> nodes[] = new Node[size];


    public class Node<K, V> {
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private K key;
        private V value;
        Node<K, V> next;
    }

    public int hash(K key) {
        return Math.abs(key.hashCode() % size);
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        if (nodes[index].key == key)
            return nodes[index].value;
        else {
            Node<K, V> node = nodes[index];
            while (node != null) {
                if (node.next != null)
                    if (node.next.key == key)
                        return node.next.value;
                    else node = node.next;
                else throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void set(K key, V value) {
        int index = hash(key);
        if (nodes[index] == null)
            nodes[index] = new Node<>(key, value);
        else {
            Node<K, V> newNode = nodes[index];
            while (newNode != null) {
                if (newNode.key.equals(key) && newNode.key.hashCode() == key.hashCode()) {
                    newNode.key = key;
                    newNode.value = value;
                    return;
                }
                newNode = newNode.next;
            }
            Node<K, V> node = nodes[index];
            while (true) {
                if (node.next != null)
                    node = node.next;
                else {
                    node.next = new Node<>(key, value);
                    break;
                }
            }
        }
    }
}

