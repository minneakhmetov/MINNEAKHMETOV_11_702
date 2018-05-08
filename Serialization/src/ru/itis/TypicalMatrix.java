package ru.itis;

public class TypicalMatrix<X, Y, V> implements Matrix<X, Y, V> {

    Node<X, Y, V> head;
    Node<X, Y, V> tail;

    @Override
    public void insert(X x, Y y, V value) {
        if (head == null){
            head = new Node(x, y, value);
            tail = head;
        }
        if(head != null){
            Node node = head;
            while (true){
                if (node.next == null){
                    node.next = new Node(x, y, value);
                    node.next.prev = node;
                    tail = node.next;
                    break;
                }
                node = node.next;
            }
        }
    }

    @Override
    public void transpose() {
        if(head != null){
            Node node = head;
            while (node != null){
                X x = (X) node.getX();
                node.setX(node.getY());
                node.setY(x);
                node = node.next;
            }
        }

    }

    @Override
    public void multiply(Matrix<X, Y, V> matrix) {


    }

    @Override
    public void subtraction(Matrix<X, Y, V> matrix) {
        while ()
    }

    private V findValueByCoordinates(X x, Y y){
        Node node = head;
        while (node != null){
            if (node.getX() == x && node.getY() == y)
                return (V) node.getValue();
        }
        return null;
    }
}
