package ru.aston.aqa.shapes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Rectangle implements Shape {

    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double calculateArea() {
        return width * height;
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
