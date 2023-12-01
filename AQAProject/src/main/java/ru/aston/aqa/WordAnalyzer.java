package ru.aston.aqa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordAnalyzer {

    private String[] words;

    public WordAnalyzer(String[] words) {
        this.words = words;
    }

    public Set<String> getUniqueWords() {
        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word);
        }
        return uniqueWords;
    }

    public Map<String, Integer> getWordFrequency() {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }

}
