package ru.itis;

import java.util.ArrayList;

public interface Matrix {
    int size();
    LinkedMatrix MatrixCode(int[][] matrix);
    int[][] decode();
    void insert(int i, int j, int value);
    void delete(int i, int j);
    ArrayList minList();
    int sumDiag();
    void transp();
    void sumCols(int j1, int j2);
    void print();
    int sizeX(int x);
    int sizeY(int y);
}
