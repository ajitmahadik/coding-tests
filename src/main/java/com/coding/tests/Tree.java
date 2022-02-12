package com.coding.tests;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class TreeMap extends HashMap<String, TreeMap> {}

public class Tree {

    public static void main(String[] args) {
        System.out.println(show(Arrays.asList("Hello World", "Hello There")));
    }

    private static TreeMap show(List<String> list) {
        TreeMap base = null;
        for (String name : list) {
            base = new TreeMap();
            String[] split = name.split(" ");
            for (String s1 : split) {
                base.computeIfAbsent(s1, v -> new TreeMap());
                base = base.get(s1);
            }
        }
        return base;
    }
}
