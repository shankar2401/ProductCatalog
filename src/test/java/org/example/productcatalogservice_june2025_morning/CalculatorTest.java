package org.example.productcatalogservice_june2025_morning;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CalculatorTest {

    @Test
    public void test() {
        Calculator calculator = new Calculator();
        int a = 5;
        int b = 10;
        assertEquals(15, calculator.add(a, b));
    }
    @Test
    public void dividetest(){
        Calculator calculator = new Calculator();
        assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
    }

}