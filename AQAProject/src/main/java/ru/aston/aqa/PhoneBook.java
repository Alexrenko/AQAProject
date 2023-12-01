package ru.aston.aqa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {

    private Map<String, Set<String>> entries;

    public PhoneBook() {
        entries = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {
        if (!entries.containsKey(surname)) {
            entries.put(surname, new HashSet<>());
        }
        entries.get(surname).add(phoneNumber);
    }

    public Set<String> get(String surname) {
        if (entries.containsKey(surname)) {
            return entries.get(surname);
        }
        return new HashSet<>();
    }

}
