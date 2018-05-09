package ru.itis;

public class Main {

    public static void main(String[] args) {
        Reader reader = new Reader();

        int[][] ints = reader.read();

        int[] edgesAndVertexes = new int[reader.edges + reader.vertexes];

        for (int i = 0; i < reader.vertexes; i++) {
            edgesAndVertexes[i] = 0;
        }

        for (int i = 0; i < ints.length; i++)
            edgesAndVertexes[ints[i][0]]++;

        for (int i = 0; i < reader.vertexes; i++)
            if (edgesAndVertexes[i] == 0)
                edgesAndVertexes[i] = -1;

        int temp = reader.vertexes, tempIndex;

        for (int i = 0; i < reader.vertexes; i++)
            if (edgesAndVertexes[i] != -1) {
                tempIndex = edgesAndVertexes[i];
                edgesAndVertexes[i] = temp;
                temp += tempIndex;
            }

        for (int i = 0; i < ints.length; i++)
            if (edgesAndVertexes[edgesAndVertexes[ints[i][0]]] == 0)
                edgesAndVertexes[edgesAndVertexes[ints[i][0]]] = ints[i][1];
            else
                edgesAndVertexes[edgesAndVertexes[ints[i][0]] + 1] = ints[i][1];

        for (int i = 0; i < edgesAndVertexes.length; i++)
            System.out.print(edgesAndVertexes[i] + " ");

        System.out.println();

        tempIndex = edgesAndVertexes.length -1;

        for (int i = reader.vertexes -1; i > -1 ; i--){
            System.out.print(i + ": ");
            if(edgesAndVertexes[i] != -1){
                for (int j = tempIndex; j > edgesAndVertexes[i] - 1; j--) {
                    System.out.print(edgesAndVertexes[j] + "  ");
                    tempIndex--;
                }
                System.out.println();
            } else
                System.out.println("infinity");
        }
    }
}
