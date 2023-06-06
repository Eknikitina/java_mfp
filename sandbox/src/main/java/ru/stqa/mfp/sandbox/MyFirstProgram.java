package ru.stqa.mfp.sandbox;

public class MyFirstProgram {

  public static void main (String[] args) {
    hello("world");
    hello("User");
    hello ("Екатерина");

    int l = 4;
    System.out.println("Площадь квадрата со стороной " + l + " равна " + area(l));
    int a = 4;
    int b = 5;
    System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " = " + area(a, b));

    double c = 3;
    double d = 5;
    System.out.println("Площадь прямоугольника со сторонами " + c + " и " + d + " равна " + area( c, d) );
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }
public static int area (int len) {
    return len * len;
}
public static int area (int a, int b) {
    return a * b;
}
public static double area (double c, double d) {
    return c * d;
}
}