package com.coding.tests;

import java.util.*;

public class DuplicateElement {

    public static void main(String[] args) {
        int[] a = {5, 4, 10, 10, 6, 4};

        findFirstDuplicateElement(a);
        findFirstDuplicateUsingMap(a);
        findFirstDuplicateElementWithLowerIndex(a);
    }

    private static void findFirstDuplicateUsingMap(int[] a) {
        System.out.print("Find first duplicate element using Linked Map: ");
        Map<Integer, Integer> counts = new HashMap<>();

        int i = 0;
        while (i < a.length) {
            if (counts.get(a[i]) == null) {
                counts.put(a[i], 1);
            } else {
                int count = counts.get(a[i]);
                counts.put(a[i], ++count);
            }

            i++;
        }

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getValue());
                break;
            }
        }
    }

    private static void findFirstDuplicateElementWithLowerIndex(int[] a) {
        System.out.print("Find first duplicate element with lower index: ");

        Set<Integer> ele = new HashSet<>();
        for (int j : a) {
            if (!ele.add(j)) {
                System.out.println(j);
                break;
            }
        }
    }

    private static void findFirstDuplicateElement(int[] a) {
        System.out.print("Find first duplicate element: ");

        int ele = -1;
        for (int i=0; i<a.length; i++) {
            for (int j=i+1; j<a.length; j++) {
                if (a[i] == a[j]) {
                    ele = a[j];
                    break;
                }
            }
            if (ele != -1) {
                System.out.println(ele);
                break;
            }
        }
    }
}
