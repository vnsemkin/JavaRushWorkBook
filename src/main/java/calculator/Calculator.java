package calculator;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Calculator {
    NumberNotFoundException e;

    public int addition(int a, int b) throws NumberNotFoundException {
        e = new NumberNotFoundException("Number a=" + a + " not equals b=" + b);
        log.trace("Value a {}, value b {}", a, b);
        log.info("Info: a=" + a + " b=" + b);
        if (a != b) {
            throw e;
        }
        return a + b;
    }

    public int subtraction(int a, int b) {
        int result = a - b;
        log.trace("a{} minus b{} result {}",a,b,result);
        return result;
    }

    public int multiply(int a, int b) {
        System.out.println("Hello World");
        return a * b;
    }

    public int division(int a, int b) {
        return a / b;
    }
}
