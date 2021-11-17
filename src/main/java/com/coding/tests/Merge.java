package com.coding.tests;

import java.util.Arrays;
import java.util.Scanner;

public class Merge {

    public static void main(String[] args) {
        Scanner s = new Scanner("1\n2222 333\nHello World");
        System.out.println(s.nextInt());
        System.out.println(s.nextDouble());
        System.out.println(s.nextLine());
        System.out.println(s.nextLine());
//        try {
//            System.out.println("Start Entering");
//            Scanner scan = new Scanner(System.in);
//            int i = scan.nextInt();
//            double d = scan.nextDouble();
//            scan.nextLine();
//            String s = scan.nextLine();
//
//            System.out.println("String: " + s);
//            System.out.println("Double: " + d);
//            System.out.println("Int: " + i);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        mergeSort();
    }

    private static void mergeSort() {
        int[] a = {1,2,5,7};
        int[] b = {2,4,6,8};

        merge(a, b);
    }

    private static void merge(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] c = new int[a.length + b.length];

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                c[k++] = a[i];
                i++;
            } else {
                c[k++] = b[j];
                j++;
            }
        }
        while (i<a.length) {
            c[k++] = a[i++];
        }
        while (j<b.length) {
            c[k++] = b[j++];
        }

        System.out.println(Arrays.toString(c));
    }
}
