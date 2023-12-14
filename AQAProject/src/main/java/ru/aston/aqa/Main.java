package ru.aston.aqa;

public class Main {

    public static void main(String[] args) {

        try {
            System.out.println("Факториал 0: " + FactorialCalculator.factorial(0));
            System.out.println("Факториал 1: " + FactorialCalculator.factorial(1));
            System.out.println("Факториал 5: " + FactorialCalculator.factorial(5));
            System.out.println("Факториал -1 (должен вызвать исключение): " + FactorialCalculator.factorial(-1));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            System.out.println("Факториал 5: " + FactorialCalculator.factorial(150));
        } catch (ArithmeticException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }

    }

}

