package ru.aston.aqa;

import ru.aston.aqa.fruits.Apple;
import ru.aston.aqa.fruits.Orange;

public class Main {

    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<>(Apple.class);
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());

        Box<Orange> orangeBox = new Box<>(Orange.class);
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        System.out.println("Вес коробки с яблоками: " + appleBox.getWeight());
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());

        if (appleBox.compare(orangeBox)) {
            System.out.println("Коробки имеют одинаковый вес");
        } else {
            System.out.println("Коробки имеют разный вес");
        }

        Box<Apple> anotherAppleBox = new Box<>(Apple.class);
        appleBox.transferTo(anotherAppleBox);
        System.out.println("Вес новой коробки с яблоками после пересыпания: " + anotherAppleBox.getWeight());
        System.out.println("Вес старой коробки с яблоками после пересыпания: " + appleBox.getWeight());

    }

}

