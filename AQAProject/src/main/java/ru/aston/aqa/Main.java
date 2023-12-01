package ru.aston.aqa;

public class Main {

    public static void main(String[] args) {

        String[] words = {
                "яблоко", "банан", "яблоко", "апельсин", "манго", "банан", "киви", "яблоко", "манго", "груша"
        };
        WordAnalyzer analyzer = new WordAnalyzer(words);

        System.out.println("Уникальные слова: " + analyzer.getUniqueWords());
        System.out.println("Частота встречаемости слов:");
        analyzer.getWordFrequency().forEach(
                (word, count) -> System.out.println(word + ": " + count)
        );


        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "+79001234567");
        phoneBook.add("Иванов", "+79009876543");
        phoneBook.add("Петров", "+79007654321");

        System.out.println("Иванов: " + phoneBook.get("Иванов"));
        System.out.println("Петров: " + phoneBook.get("Петров"));
        System.out.println("Сидоров: " + phoneBook.get("Сидоров"));

    }

}

