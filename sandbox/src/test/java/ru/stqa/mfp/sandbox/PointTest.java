package ru.stqa.mfp.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

  // задаю точки
  public static final Point p1 = new Point(1, 2);
  public static final Point p2 = new Point(2, 1);

  // тест для метода класса MyFirstProgram
  @Test
  public void testDistance1() {
    Assert.assertEquals(MyFirstProgram.distance(p1, p2), 1.4142135623730951);
  }

  // static
  @Test
  public void testDistance2() {
    Assert.assertEquals(Point.distance(p1, p2), 1.4142135623730951);
  }

  // non-static
  @Test
  public void testDistance3() {
    Assert.assertEquals(p1.distance(p2), 1.4142135623730951);
  }
}

