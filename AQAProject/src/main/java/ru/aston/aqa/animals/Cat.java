package ru.aston.aqa.animals;

public class Cat extends Animal {
    private static int count;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        super(name);
        count++;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " пробежал 200 метров и устал");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eat(Plate p) {
        if (p.getFood() >= appetite && !satiety) {
            p.decreaseFood(appetite);
            satiety = true;
            System.out.println(name + " наелся и доволен.");
        } else {
            System.out.println(name + " все еще голоден.");
        }
    }

    public boolean isSatiety() {
        return satiety;
    }

}
