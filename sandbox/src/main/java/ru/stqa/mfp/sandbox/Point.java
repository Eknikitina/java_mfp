package ru.stqa.mfp.sandbox;

public class Point {
  public int x;
  public int y;

  public Point( int x, int y) {
    this.x = x;
    this.y = y;
  }

  // 1 вариант
  public static double distance(Point p1, Point p2) {
    return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
  }

  // 2 вариант
  public double distance(Point p) {
    return Math.sqrt(Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2));
  }
}