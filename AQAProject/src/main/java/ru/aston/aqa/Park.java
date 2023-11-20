package ru.aston.aqa;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Park {

    private String name;
    private final List<Attraction> attractions = new ArrayList<>();

    public Park(String name) {
        this.name = name;
    }

    public void addAttraction(String attractionName, String workingHours, double price) {
        attractions.add(new Attraction(attractionName, workingHours, price));
    }

    public void printParkInfo() {
        System.out.println("Парк: \"" + name + "\"");
        for (Attraction attraction : attractions) {
            attraction.printInfo();
        }
    }

    public class Attraction {
        private String attractionName;
        private String workingHours;
        private double price;

        public Attraction(String attractionName, String workingHours, double price) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void printInfo() {
            System.out.printf(Locale.US,"%s - время работы: %s, цена: %.2f руб.%n", attractionName, workingHours, price);
        }
    }

}
