package com.coding.tests;

import java.util.Scanner;

public class LimitedATM {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int maxDailyLimit = 100_000;
        int totalWithdrawn = 0;
        int[] notes = {5000, 2000, 1000, 500, 100, 50, 10};

        while (totalWithdrawn <= maxDailyLimit && scan.hasNext()) {
            try {
                int amount = Integer.parseInt(scan.next());
                if (amount <= 20000 && amount % 10 == 0) {
                    for (int note : notes) {
                        if (amount >= note) {
                            int currencyCount = amount / note;
                            amount %= note;
                            System.out.printf("%d %d,", note, currencyCount);
                        }
                    }
                    totalWithdrawn += amount;
                } else {
                    System.out.println("please enter correct");
                }
            } catch (NumberFormatException e) {
                System.out.println("please enter correct");
            }
        }
        System.out.println(totalWithdrawn);
        scan.close();
    }
}
