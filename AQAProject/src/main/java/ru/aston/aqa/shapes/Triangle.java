package ru.aston.aqa.shapes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Triangle implements Shape {

    private double sideA;
    private double sideB;
    private double sideC;
    private String fillColor;
    private String borderColor;

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double calculateArea() {
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
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
