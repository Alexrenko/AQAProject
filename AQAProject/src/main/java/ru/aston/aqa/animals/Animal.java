package ru.aston.aqa.animals;

public abstract class Animal {
    protected String name;
    protected static int count = 0;

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);
}
