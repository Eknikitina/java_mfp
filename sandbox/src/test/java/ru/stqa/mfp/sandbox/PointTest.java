package ru.stqa.mfp.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {
  @Test
  public void testDistance() {
    Point p =  new Point(2, 4, 6, 8);
    Assert.assertEquals(p.distance(), 5.656854249492381);
  }
}
