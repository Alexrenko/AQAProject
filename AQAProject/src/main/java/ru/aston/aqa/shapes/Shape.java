package ru.aston.aqa.shapes;

public interface Shape {

    double calculatePerimeter();
    double calculateArea();

    default String getFillColor() {
        return "Белый";
    }

    default String getBorderColor() {
        return "Черный";
    }

}
