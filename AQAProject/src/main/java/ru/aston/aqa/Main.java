package ru.aston.aqa;

import ru.aston.aqa.animals.Animal;
import ru.aston.aqa.animals.Cat;
import ru.aston.aqa.animals.Dog;
import ru.aston.aqa.animals.Plate;
import ru.aston.aqa.shapes.Circle;
import ru.aston.aqa.shapes.Rectangle;
import ru.aston.aqa.shapes.Shape;
import ru.aston.aqa.shapes.Triangle;

public class Main {

    public static void main(String[] args) {

        catAndDogRunAndSwim();
        printAnimalStatistic();
        feedingCats();

        Shape[] shapes = new Shape[] {
                new Circle(7, "зеленый", "темно-зеленый"),
                new Rectangle(5, 10, "оранжевый", "синий"),
                new Triangle(3, 3, 3, "белый", "черный")
        };

        for(Shape shape : shapes) {
            System.out.println(shape);
        }

    }

    public static void catAndDogRunAndSwim() {
        Animal[] animals = {
                new Dog("Шарик"),
                new Cat("Матроскин", 5),
        };

        for(Animal animal : animals) {
            animal.run(100);
            animal.run(600);
            animal.swim(5);
            animal.swim(15);
        }
    }

    public static void printAnimalStatistic() {
        System.out.printf(
                "%nСтатистика:%n" +
                "\tКоличество животных: %d%n" +
                "\tКоличество котов: %d%n" +
                "\tКоличество собак: %d%n%n", Animal.getCount(), Cat.getCount(), Dog.getCount());
    }

    public static void feedingCats() {
        Cat[] cats = {
                new Cat("Barsik", 5),
                new Cat("Murzik", 10),
                new Cat("Vasya", 4)
        };

        Plate plate = new Plate(15);
        plate.info();

        // кормим котов
        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println("Еды осталось - " + plate.getFood());
        }

        // добавляем еду и кормим Васю
        System.out.println("Добавляем еду в тарелку.");
        plate.addFood(4);
        plate.info();
        cats[2].eat(plate);
        System.out.println(cats[2].getName() + " сытость: " + cats[2].isSatiety());
    }

}

