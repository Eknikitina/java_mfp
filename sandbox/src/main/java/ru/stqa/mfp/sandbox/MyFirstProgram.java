package ru.stqa.mfp.sandbox;

public class MyFirstProgram {

  public static void main (String[] args) {
    hello("world");
    hello("User");
    hello ("Екатерина");



    Square s = new Square(4);
    System.out.println("Площадь квадрата со стороной " + s.l + " равна " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

    Point p = new Point(0, 2, 4, 6);
    System.out.println("Дистанция между точками равна " + p.distance());
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }
  }


