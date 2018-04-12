package ru.itis;

public class Tree<T extends Comparable> {

    Node root;
    int sum = 0;

    Tree() {
        this.root = new Node(0);
    }

    int position = 0;

    public void convert(T[] array, int K) {
        convert(root, array, K);
    }

    int k = -1;

    private void convert(Node node, T[] array, int K) {
        try {
            node.nodes = new Node[K];
            for (int i = 0; i < K; i++) {
                node.nodes[i] = new Node(array[position]);
                node.nodes[i].parent = node;
                position++;
            }
            k++;
            if (node == root) {
                sum++;
                convert(node.nodes[0], array, K);
            } else if (k == K) {
                k = 0; sum++;
                convert(node.nodes[k], array, K);
            } else {
                convert(node.parent.nodes[k], array, K);
                sum++;
            }

        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }

    public void print() {
        print(root);
    }

    private void print(Node node) {
        try {
            for (int i = 0; i < node.nodes.length; i++)
                System.out.print(node.nodes[i].value + "Parent:" + node.value + "   ");
            System.out.println();
            for (int i = 0; i < node.nodes.length; i++)
                print(node.nodes[i]);
        } catch (NullPointerException e) {

        }

    }

    public void squarePrint(){
        System.out.println();
        System.out.println("Количесвто квадратов " + sum);
    }

}
