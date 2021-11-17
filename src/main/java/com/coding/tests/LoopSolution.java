package com.coding.tests;

import java.util.StringJoiner;

public class LoopSolution {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        //        Scanner in = new Scanner(System.in);
//        int t=in.nextInt();
        int t = 1;
        for(int i=0;i<t;i++){
//            int a = in.nextInt();
//            int b = in.nextInt();
//            int n = in.nextInt();
            int a = 5;
            int b = 3;
            int n = 5;

            int j = 0;
            int prevResult = a;
            StringJoiner result = new StringJoiner(" ");
            while (n-- > 0) {
                prevResult = prevResult + ((int)Math.pow(2, j++) * b);
                result.add(Integer.toString(prevResult));
            }
            System.out.println(result);
        }
//        in.close();

    }
}
