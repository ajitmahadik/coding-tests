package com.coding.tests;

import java.util.*;

public class MoneyHeist {

    public static List<String> extractData(String hierarchicalData, int level) {
        String[] split = hierarchicalData.split("\n");
        Map<Integer, List<String>> map = new HashMap<>();

        int l = 0;
        for (String s: split) {
            if (!(s.contains("{") || s.contains("}"))) {
                map.computeIfPresent(l, (k, v) -> {
                    v.add(s.trim());
                    return v;
                });
                l++;
            } else {
                if (s.contains("{")) {
                    map.computeIfAbsent(l, v -> new ArrayList<>());
                } else if (s.contains("}")) {
                    l--;
                }
            }
        }
        return map.get(level);
    }

    public static void main(String[] args) {
        String input = "\"{\\n    Money Heist\\n    {\\n        The most important character Professor\\n    }\\n    {\\n        Another character is Berlin\\n        {\\n            Berlin is in charge of the heist\\n        }\\n    }\\n    {\\n        Another character is Moscow\\n        {\\n            Moscow is Denver's father\\n        }\\n    }\\n    {\\n        Another character is Rio\\n        {\\n            Rio is a computer programmer\\n            {\\n                Rio is also a good hacker\\n                {\\n                    Rio is very happy to be a part of the heist\\n                }\\n            }\\n        }\\n    }\\n    {\\n        Another character is Denver\\n    }\\n}\\n";
        System.out.println(input.replace("\\n", "\n"));
        List<String> data = extractData(input.replace("\\n", "\n"), 2);
        System.out.println(data);
    }
}
