package com.coding.tests;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DuplicateElement {

    public static void main(String[] args) {
        int[] a = {5, 4, 10, 10, 6, 4};

        findFirstDuplicateElement(a);
        findFirstDuplicateUsingMap(a);
        findFirstDuplicateElementWithLowerIndex(a);

        System.out.println("Using Java-8");
        List<Integer> nums = IntStream.of(a).boxed().collect(Collectors.toList());

        System.out.println("Duplicate elements");
        nums.stream().filter(num -> Collections.frequency(nums, num) > 1).collect(Collectors.toSet()).forEach(System.out::println);

        System.out.println("Remove Duplicate elements");
        removeDuplicateElements(a);

        System.out.println("Get non-duplicate elements");
        nums.stream().filter(num -> Collections.frequency(nums, num) == 1).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("Group element counts");
        nums.stream().collect(Collectors.groupingBy(num -> num, Collectors.counting())).forEach((k,v) -> System.out.printf("%d appears %d times%n", k, v));
    }

    private static void removeDuplicateElements(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        if (n==0 || n==1){
            IntStream.of(nums).boxed().forEach(i -> System.out.printf("%d ", i));
        }
        int[] temp = new int[n];
        int j = 0;
        for (int i=0; i<n-1; i++){
            if (nums[i] != nums[i+1]){
                temp[j++] = nums[i];
            }
        }
        temp[j++] = nums[n-1];
        nums = Arrays.copyOf(temp, j);
        IntStream.of(nums).boxed().forEach(i -> System.out.printf("%d ", i));
        System.out.println("");
    }

    private static void findFirstDuplicateUsingMap(int[] numbers) {
        System.out.print("Find first duplicate element using Linked Map: ");
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : numbers) {
            int count = 1;

            if (counts.get(num) != null) {
                count = counts.get(num);
                count += 1;
            }
            counts.put(num, count);
        }

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
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
