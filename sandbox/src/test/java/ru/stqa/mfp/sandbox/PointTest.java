package ru.stqa.mfp.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

  @Test
  public void testDistance() {
    Point point1 = new Point(2.0, 6.0);
    Point point2 = new Point(4.0, 8.0);
    Assert.assertEquals(point1.distance(point2), 2.8284271247461903);
  }
}

