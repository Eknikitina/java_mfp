package ru.stqa.mfp.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EquationTest {

  @Test
  public void tests0() {
    Equation e = new Equation(1, 1, 1);
    Assert.assertEquals(e.rootNumber(), 0);
  }

  @Test
  public void tests1() {
    Equation e = new Equation(1, 2, 1);
    Assert.assertEquals(e.rootNumber(), 1);
  }

  @Test
  public void tests2() {
    Equation e = new Equation(1, 5, 6);
    Assert.assertEquals(e.rootNumber(), 2);
  }

  @Test
  public void testsLinear() {
    Equation e = new Equation(0, 1, 1);
    Assert.assertEquals(e.rootNumber(), 1);
  }

  @Test
  public void testsConstant() {
    Equation e = new Equation(0, 0, 1);
    Assert.assertEquals(e.rootNumber(), 0);
  }

  @Test
  public void testsZero() {
    Equation e = new Equation(0, 0, 0);
    Assert.assertEquals(e.rootNumber(), -1);
  }
}
