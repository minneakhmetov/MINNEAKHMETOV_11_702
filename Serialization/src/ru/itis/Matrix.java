package ru.itis;

public interface Matrix<X, Y, V> {
    void insert(X x, Y y, V value);
    void transpose();
    void multiply(Matrix<X, Y, V> matrix);
    void subtraction(Matrix<X, Y, V> matrix);
}
