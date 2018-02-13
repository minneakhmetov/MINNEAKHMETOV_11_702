package ru.itis;

public class Main {

    public static void main(String[] args) {
        Rectangle rect = new Rectangle(1, 1, 1, 2, 2, 2, 2, 1);
        rect.move(1, 1); //на сколько надо передвинуть
        rect.print();
        rect.change(4, 3); // вводится координата диагональной координаты от левого нижнего
        rect.print();
    }
}
