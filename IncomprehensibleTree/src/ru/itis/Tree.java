package ru.itis;

public class Tree<T extends Comparable> {

    Node root;

    Tree (){
        this.root = new Node(0);
    }
    int position = 0;

    public void convert(T[] array, int K){
        convert(root, array, K);
    }
    private void convert(Node node, T[] array, int K){
        try {
            node.nodes = new Node[K];
            for (int i = 0; i < K; i++) {
                node.nodes[i] = new Node(array[position]);
                position++;
            }
            for (int i = 0; i < K; i++)
                convert(node.nodes[i], array, K);
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }

    public void print(){
        print(root);
    }
    private void print(Node node){
        try {
            for (int i = 0; i < node.nodes.length; i++)
                System.out.print(node.nodes[i].value +  "Parent:" + node.value + "   ");
            System.out.println();
            for (int i = 0; i < node.nodes.length; i++)
                print(node.nodes[i]);
        } catch (NullPointerException e){

        }
    }

}
