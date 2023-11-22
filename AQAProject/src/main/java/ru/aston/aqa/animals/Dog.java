package ru.aston.aqa.animals;

import ru.aston.aqa.animals.Animal;

public class Dog extends Animal {
    private static int count;

    public Dog(String name) {
        super(name);
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " пробежал 500 метров и устал");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " проплыл 10 метров и устал");
        }
    }

}
