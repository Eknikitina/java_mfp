package ru.stqa.mfp.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

  @Test
  public void testDistanceTrue() {
    Point point1 = new Point(2.0, 6.0);
    Point point2 = new Point(4.0, 8.0);
    Assert.assertEquals(point1.distance(point2), 2.8284271247461903);
  }
  @Test
  public void testDistanceFalse() {
    Point point1 = new Point(2.0, 4.0);
    Point point2 = new Point(6.0, 8.0);
    Assert.assertNotEquals(point1.distance(point2), 2.8284271247461903, "Result is invalid!");
  }
}

