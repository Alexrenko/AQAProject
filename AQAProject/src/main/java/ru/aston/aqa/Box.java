package ru.aston.aqa;

import ru.aston.aqa.fruits.Fruit;

import java.util.ArrayList;

class Box<T extends Fruit> {
    private final ArrayList<T> fruits = new ArrayList<>();
    private Class<T> fruitType;

    public Box(Class<T> fruitType) {
        this.fruitType = fruitType;
    }

    public void addFruit(T fruit) {
        if (fruit.getClass().equals(fruitType)) {
            fruits.add(fruit);
        } else {
            throw new IllegalArgumentException("Нельзя добавить разные типы фруктов в одну коробку");
        }
    }

    public float getWeight() {
        float weight = 0.0f;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.001;
    }

    public void transferTo(Box<T> anotherBox) {
        if (anotherBox == null) {
            throw new IllegalArgumentException("Переданная коробка не может быть null");
        }
        if (this == anotherBox) {
            return;
        }
        for (T fruit : fruits) {
            anotherBox.addFruit(fruit);
        }
        fruits.clear();
    }
}