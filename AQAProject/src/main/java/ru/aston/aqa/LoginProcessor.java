package ru.aston.aqa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginProcessor {

    private Scanner scanner = new Scanner(System.in);

    public void processLogins() {
        List<String> logins = new ArrayList<>();

        while (true) {
            System.out.println("Введите логин (или пустую строку для завершения):");
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            }
            logins.add(input);
        }

        System.out.println("Логины, начинающиеся на 'f':");
        logins.stream()
            .filter(login -> login.startsWith("f"))
            .forEach(System.out::println);
    }

}
