package ru.stqa.mfp.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.mfp.sandbox.Square;


public class SquareTest {
@Test
  public void testArea() {
    Square s = new Square(5);
  Assert.assertEquals(s.area(), 25);
  }
}
