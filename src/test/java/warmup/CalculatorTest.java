package warmup;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTest {

  //Dane wejściowe
  public static final int FIRST_NUMBER = 2;
  public static final int SECOND_NUMBER = 3;

  //Utworzenie instancji kalkulatora
  Calculator calculator = new Calculator();

  //Wyniki oczekiwane
  private int correctExceptedResult = 5;
  private int incorrectExceptedResult = 6;

  @Test(enabled = false)
  public void testCase1() {
    int actualResult = calculator.add(FIRST_NUMBER, SECOND_NUMBER);
    assertTrue(correctExceptedResult == actualResult);
  }

  @Test(enabled = false)
  public void testCase2() {
    int actualResult = calculator.add(FIRST_NUMBER, SECOND_NUMBER);
    assertFalse(incorrectExceptedResult == actualResult);
  }

  @Test(enabled = false)
  public void testCase3() {
    int actualResult = calculator.add(FIRST_NUMBER, SECOND_NUMBER);
    assertEquals(actualResult, correctExceptedResult);
  }

}