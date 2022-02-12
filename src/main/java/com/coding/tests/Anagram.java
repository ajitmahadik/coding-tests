package com.coding.tests;

import java.util.Arrays;

public class Anagram {

    public static void main(String[] args) {
        anagram("CODE", "DOCE");
        anagram("BBBA", "AAAB");
        anagram("BA", "ABAB");
    }

    private static void anagram(String s, String t) {
        String s1 = s.replaceAll("\\s", "");
        String s2 = t.replaceAll("\\s", "");

        boolean status = false;

        if (s1.length() == s2.length()) {
            char[] arrayS1 = s1.toLowerCase().toCharArray();
            char[] arrayS2 = s2.toLowerCase().toCharArray();
            Arrays.sort(arrayS1);
            Arrays.sort(arrayS2);
            status = Arrays.equals(arrayS1, arrayS2);
        }

        System.out.printf("%s and %s are %s%n", s1, s2, status ? "anagrams" : "not anagrams");
    }
}
