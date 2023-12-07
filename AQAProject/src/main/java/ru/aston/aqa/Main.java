package ru.aston.aqa;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static Collection<Student> students = Arrays.asList(
            new Student("Дмитрий", 17, Gender.MAN),
            new Student("Максим", 20, Gender.MAN),
            new Student("Екатерина", 20, Gender.WOMAN),
            new Student("Михаил", 28, Gender.MAN)
    );

    public static void main(String[] args) {

        // 1.
        List<Integer> randomNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Количество чётных чисел: " + countEvenNumbers(randomNumbers));

        // 2.
        List<String> stringCollection = Arrays.asList("Highload", "High", "Load", "Highload");
        System.out.println("Количество объектов 'High': " + countOccurrences(stringCollection, "High"));
        System.out.println("Первый элемент коллекции: " + firstElementOrZero(stringCollection));
        System.out.println("Последний элемент коллекции: " + lastElementOrZero(stringCollection));

        // 3.
        List<String> unsortedStrings = Arrays.asList("f10", "f15", "f2", "f4", "f4");
        String[] sortedArray = sortAndToArray(unsortedStrings);
        System.out.println("Отсортированный массив: " + Arrays.toString(sortedArray));

        // 4.
        System.out.println("Средний возраст студентов мужского пола: " + averageAgeOfMaleStudents(students));
        System.out.println("Студенты, кому грозит получение повестки: " + studentsAtRiskOfDraft(students));

        // 5.
        LoginProcessor processor = new LoginProcessor();
        processor.processLogins();

    }

    private static long countEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 == 0).count();
    }

    private static long countOccurrences(List<String> collection, String element) {
        return collection.stream().filter(element::equals).count();
    }

    private static String firstElementOrZero(List<String> collection) {
        return collection.stream().findFirst().orElse("0");
    }

    private static String lastElementOrZero(List<String> collection) {
        return collection.stream().reduce((first, second) -> second).orElse("0");
    }

    private static String[] sortAndToArray(List<String> collection) {
        return collection.stream()
                .filter(s -> s.length() > 1 && Character.isLetter(s.charAt(0)) && isNumeric(s.substring(1)))
                .sorted(Comparator.comparingInt(s -> Integer.parseInt(s.substring(1))))
                .toArray(String[]::new);
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static double averageAgeOfMaleStudents(Collection<Student> students) {
        return students.stream()
                .filter(student -> student.getGender() == Gender.MAN)
                .mapToInt(Student::getAge)
                .average()
                .orElse(0.0);
    }

    private static List<String> studentsAtRiskOfDraft(Collection<Student> students) {
        return students.stream()
                .filter(student -> student.getGender() == Gender.MAN)
                .filter(student -> student.getAge() >= 18 && student.getAge() <= 27)
                .map(Student::getName)
                .collect(Collectors.toList());
    }

}

