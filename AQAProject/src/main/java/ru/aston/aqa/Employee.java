package ru.aston.aqa;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public void printInfo() {
        String info = String.format(
                "%s%n\tдолжность: %s%n\temail: %s%n\tтелефон: %s%n\tзарплата: %d%n\tвозраст: %d%n",
                fullName, position, email, phone, salary, age
        );
        System.out.println(info);
    }

}
