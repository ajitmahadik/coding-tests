package com.coding.tests;

public class Example {

    public static Integer compareNumber(Integer a, Integer b) {
        return a.compareTo(b);
    }

    public static void main(String[] args) {
        Integer result = Integer.valueOf(2).compareTo(3);
        System.out.println(result);
    }
}
