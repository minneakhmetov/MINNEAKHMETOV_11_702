package ru.itis;

public class Main {

    public static void main(String[] args) {
	Shape shapes[] = new Shape[4];
    Shape curcle = new Curcle(1);
	Shape square = new Square(1);
	Shape ellipse = new Ellipse(1, 4);
	Shape rectangle = new Rectangle(2, 4);

	shapes[0] = curcle;
	shapes[1] = square;
	shapes[2] = ellipse;
	shapes[3] = rectangle;

	for(int i = 0; i<4; i++) {
        System.out.println(shapes[i].getArea());
        System.out.println(shapes[i].getPerimeter());
    }

    }
}
