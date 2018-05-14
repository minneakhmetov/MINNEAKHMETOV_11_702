package ru.itis;

import java.util.Stack;

public class Graph {

    //максимальное количество вершин в графе
    private int VERTEX_SIZE = 100;
    //массив для хранения вершин
    private Vertex[] vertexList;
    //текущее количество вершин в графе
    private int vertexCount;
    //матрица смежности
    private int[][] matrix;
    Stack<Integer> stack = new Stack();

    public Graph(){
        matrix = new int[VERTEX_SIZE][VERTEX_SIZE];
        //перед началом работы заполняем матрицу смежности нулями
        for(int i = 0; i < VERTEX_SIZE; i++)
            for(int j = 0; j < VERTEX_SIZE; j++)
                matrix[i][j] = 0;
        vertexCount = 0;
        vertexList = new Vertex[VERTEX_SIZE];
    }

    public void addVertex(String label){
        vertexList[vertexCount++] = new Vertex(label);
    }

    //добавление ребра
    public void addEdge(int begin, int end){
        matrix[begin][end] = 1;
        matrix[end][begin] = 1;
    }

    //метод возвращает непосещенную вершину, смежную по отношению к v
    int getSuccessor (int v){
        for(int j = 0; j < vertexCount; j++)
            if(matrix[v][j] == 1 && vertexList[j].isVisited() == false)
                return j; //возвращает первую найденную вершину
        return -1; //таких вершин нет
    }

    // обход в глубину
    int dfs(int v){
        int count = 0;

        vertexList[v].setVisited(true); //алгоритм начинает обход с вершины 0
        stack.push(0); //занесение в стек

        while(!stack.isEmpty()){ //пока стек не опустеет
            int current = stack.peek();
            //получение непосещенной вершины, смежной с текущей
            int vertex = getSuccessor (current);
            if(vertex == -1)
                stack.pop();//элемент извлекается из стека
            else //если вершина найдена
            {
                vertexList[vertex].setVisited(true);//пометка
                //displayVertex(vertex);//вывод
                count++;
                stack.push(vertex);//занесение в стек
            }
        }

//сброс флагов
        for(int j = 0; j < vertexCount; j++)//сброс флагов
            vertexList[j].setVisited(false);
        return ++count;
    }

    boolean isConnected(){
        return vertexCount == dfs(0);
    }

    boolean dfs(int i, boolean[] col) {

        if (col[i]) {
            return false;
        }
        col[i] = true;

        boolean result = true;

        for (int j = 0; j < vertexCount; ++j) {
            if (matrix[i][j] != 0) {
                result &= dfs(j, col);
            }
        }
        return result;
    }

    boolean isTree() {
        int edges = 0;
        for (int i = 0; i < vertexCount; ++i) {
            for (int j = i + 1; j < vertexCount; ++j) {
                if (matrix[i][j] != 0) {
                    edges++;
                }
            }
        }
        if (edges != vertexCount - 1) {
            return false;
        }

        boolean[] col = new boolean[vertexCount];

        dfs(0, col);

        for (int i = 0; i < vertexCount; ++i) {
            if (!col[i]) {
                return false;
            }
        }
        return true;
    }




}
