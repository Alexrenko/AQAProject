package ru.aston.aqa;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Employee[] employees = createFiveEmployees();
        for (Employee e : employees) {
            if (e.getAge() > 40) {
                e.printInfo();
            }
        }

        Park park = new Park("Диво остров");
        park.addAttraction("Колесо обозрения", "10:00-22:00", 150);
        park.addAttraction("Американские горки", "10:00-20:00", 300);
        park.printParkInfo();
    }

    public static Employee[] createFiveEmployees() {
        return new Employee[]{
                new Employee("Иванов Иван Иванович", "тестировщик ПО",
                        "ivan@company.ru", "+79993332211", 100000, 35),
                new Employee("Петрова Анна Валерьевна", "тестировщик ПО",
                        "anna@company.ru", "+79992345678", 120000, 42),
                new Employee("Сидоров Андрей Сергеевич", "разработчик ПО",
                        "andrey@company.ru", "+79992224566", 90000, 37),
                new Employee("Петренко Дарья Васильевна", "разработчик ПО",
                        "darya@company.ru", "+79997775544", 140000, 28),
                new Employee("Максимов Максим Константинович", "аналитик",
                        "maksim@company.ru", "+79992227788", 100000, 45),
        };
    }
}

