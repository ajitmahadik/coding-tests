package com.coding.tests;

import java.util.HashMap;
import java.util.Map;

interface WeatherAPI {
    Integer currentTemp();
}

class Weather implements WeatherAPI {

    @Override
    public Integer currentTemp() {
        return 28;
    }
}

public class WeatherFetcher implements Runnable {
    private final String city;
    private final WeatherAPI api;
    private static final Map<String, Integer> cityTemps = new HashMap<>();
    WeatherFetcher(String city) {
        this.city = city;
        this.api = new Weather();
    }

    @Override
    public void run() {
        Integer temp = api.currentTemp();
        collectTemps(this.city, temp);
    }

    private static void collectTemps(String city, int temp) {
        synchronized (cityTemps) {
            cityTemps.put(city, temp);
        }
    }

    public static void main(String[] args) {
        WeatherFetcher mumbai = new WeatherFetcher("Mumbai");
        WeatherFetcher pune = new WeatherFetcher("Pune");
        ThreadGroup group = new ThreadGroup("Weather Group");
        Thread tMumbai = new Thread(group, mumbai);
        Thread tPune = new Thread(group, pune);
        tMumbai.start();
        tPune.start();
        try {
            tMumbai.join();
            tPune.join();
        } catch (InterruptedException e) {
            group.interrupt();
            e.printStackTrace();
        }
        cityTemps.forEach((city, temp) -> System.out.printf("The temp in %s is %d %n", city, temp));
    }
}
