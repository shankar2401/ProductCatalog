package org.example.productcatalogservice_june2025_morning;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    public int divide(int a, int b) {
        try{
            return a / b;
        } catch (ArithmeticException e) {
            throw e;
        }
    }
}
