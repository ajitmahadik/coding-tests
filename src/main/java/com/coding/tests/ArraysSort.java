package com.coding.tests;

import java.util.Arrays;

public class ArraysSort {
    public static void main(String[] args) {
        String[] names = new String[] {"Pune", "Mumbai", "Brussels"};
        Arrays.sort(names);
        for (String name:names) {
            System.out.println(name);
        }
    }
}
