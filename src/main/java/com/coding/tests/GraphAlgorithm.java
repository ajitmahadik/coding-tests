package com.coding.tests;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class GraphAlgorithm {

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("a", List.of("b", "c"));
        graph.put("b", List.of("d"));
        graph.put("d", List.of("e"));
        graph.put("e", Collections.emptyList());
        graph.put("c", List.of("f"));
        graph.put("f", Collections.emptyList());

        depthFirst(graph, "a");
        System.out.println("");
        depthFirstRecursive(graph, "a");
        System.out.println("");
        breadthFirst(graph, "a");
    }

    private static void depthFirst(Map<String, List<String>> graph, String source) {
        Deque<String> deque = new ArrayDeque<>();
        deque.push(source);

        while (!deque.isEmpty()) {
            String node = deque.pop();
            System.out.print(node + " ");

            for (String n : graph.get(node)) {
                deque.push(n);
            }
        }
    }

    private static void depthFirstRecursive(Map<String, List<String>> graph, String source) {
        System.out.print(source + " ");
        List<String> nodes = graph.get(source);
        for (String node : nodes) {
            depthFirstRecursive(graph, node);
        }
    }

    private static void breadthFirst(Map<String, List<String>> graph, String source) {
        Queue<String> queue = new ArrayDeque<>();
        queue.add(source);
        while(!queue.isEmpty()) {
            String node = queue.remove();
            System.out.print(node + " ");

            queue.addAll(graph.get(node));
        }
    }

}
