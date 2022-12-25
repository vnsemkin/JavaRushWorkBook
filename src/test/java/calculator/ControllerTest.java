package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class ControllerTest {
    Calculator calculator = new Calculator();

    @Test
    public void addition() throws NumberNotFoundException {
        //GIVEN
        int actualCase1 = calculator.addition(2, 2);
        int actualCase2 = calculator.addition(34, 34);
        //WHEN
        int expectedCase1 = 4;
        int expectedCase2 = 68;
        //THEN
        Assertions.assertEquals(expectedCase1, actualCase1);
        Assertions.assertEquals(expectedCase2, actualCase2);
    }

    @Test
    public void subtraction() {
        //GIVEN
        int actualCase1 = calculator.subtraction(2, 2);
        int actualCase2 = calculator.subtraction(-10, 34);
        //WHEN
        int expectedCase1 = 0;
        int expectedCase2 = -44;
        //THEN
        Assertions.assertEquals(expectedCase1, actualCase1);
        Assertions.assertEquals(expectedCase2, actualCase2);
    }

    @Test
    public void multiplication() {
        //GIVEN
        int actualCase1 = calculator.multiply(2, 2);
        int actualCase2 = calculator.multiply(-10, 34);
        //WHEN
        int expectedCase1 = 4;
        int expectedCase2 = -340;
        //THEN
        Assertions.assertEquals(expectedCase1, actualCase1);
        Assertions.assertEquals(expectedCase2, actualCase2);
    }

    @Test
    public void division() {
        //GIVEN
        int actualCase1 = calculator.division(2, 2);
        int actualCase2 = calculator.division(-10, 2);
        //WHEN
        int expectedCase1 = 1;
        int expectedCase2 = -5;
        //THEN
        Assertions.assertEquals(expectedCase1, actualCase1);
        Assertions.assertEquals(expectedCase2, actualCase2);
    }
}
