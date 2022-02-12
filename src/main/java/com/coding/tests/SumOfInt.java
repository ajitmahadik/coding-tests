package com.coding.tests;

public class SumOfInt {

    public static void main(String[] args) {
        int number = 1234;

        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            number = number / 10;
        }
        System.out.printf("%d%n", sum);
    }
}
