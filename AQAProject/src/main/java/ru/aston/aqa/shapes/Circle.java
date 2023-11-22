package ru.aston.aqa.shapes;

import lombok.AllArgsConstructor;
import ru.aston.aqa.animals.Cat;
import ru.aston.aqa.animals.Dog;

@AllArgsConstructor
public class Circle implements Shape {

    private double radius;
    private String fillColor;
    private String borderColor;

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public String toString() {
        return String.format("%nФигура: %s%nПериметр: %.1f%nПлощадь: %.1f%nЦвет заливки: %s%nЦвет границы: %s",
                this.getClass().getSimpleName(),
                this.calculatePerimeter(),
                this.calculateArea(),
                this.getFillColor(),
                this.getBorderColor()
        );
    }
}
