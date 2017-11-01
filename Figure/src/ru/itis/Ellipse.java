package ru.itis;

public class Ellipse extends Shape {

    private int a;
    private int b;
    //area = a*b*3;
   // perimeter = (a + b) * 3;

    public Ellipse(int a, int b) {
        this.a = a;
        this.b = b;
        super.area = area();
        super.perimeter = perimeter();
    }

  public int area(){
       return a*b*3;
  }


  public int perimeter() {
        return (a + b) * 3;
   }
}
