package ru.stqa.mfp.sandbox;

public class Point {
  public double p1;
  public double p2;

  public Point(double p1, double p2) {
    this.p1 = p1;
    this.p2 = p2;
  }

  public double distance(Point point) {
    return Math.sqrt((point.p1 - this.p1) * (point.p1 - this.p1) + (this.p2 - point.p2) * (this.p2 - point.p2));
  }
}