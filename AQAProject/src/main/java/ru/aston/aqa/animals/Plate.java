package ru.aston.aqa.animals;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int amount) {
        if (food >= amount) {
            food -= amount;
        } else {
            System.out.println("В тарелке не хватает еды.");
        }
    }

    public void addFood(int amount) {
        food += amount;
    }

    public int getFood() {
        return food;
    }

    public void info() {
        System.out.println("Еды в тарелке - " + food);
    }
}
