package calculator;

/**
 * Hello world!
 **/
public class Controller {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        try {
            calculator.addition(5,5);
        } catch (NumberNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(calculator.subtraction(10, 5));
        calculator.multiply(15,15);
        calculator.division(10, 67);
    }
}