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

    Point p1 = new Point(1, 2);
    Point p2 = new Point(2, 1);
    System.out.println("Расстояние между точками " + p1 + " и " + p2 + " = " + distance(p1, p2));

    // 1 вариант
    System.out.println("Расстояние между точками " + p1 + " и " + p2 + " = " + Point.distance(p1, p2));

    // 2 вариант
    System.out.println("Расстояние между точками " + p1 + " и " + p2 + " = " + p1.distance(p2));
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }
  public static double distance(Point p1, Point p2) {
    return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
  }
}