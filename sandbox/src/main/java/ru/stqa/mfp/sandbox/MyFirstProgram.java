package ru.stqa.mfp.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("User");
    hello("Екатерина");

    Square s = new Square(4);
    System.out.println("Площадь квадрата со стороной " + s.l + " равна " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

    Point p1 = new Point(2, 6);
    Point p2 = new Point(4, 8);
    System.out.println(p1.distance(p2));
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }
}