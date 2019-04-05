package com.codecool.csepdo.FilePartReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class FileWordAnalyzer {
    private FilePartReader text;

    public FileWordAnalyzer(FilePartReader filePart) {
        this.text = filePart;
    }

    public ArrayList<String> getWordsOrderedAlphabetically() {
        ArrayList<String> textArrayList = getText();
        textArrayList.sort(String::compareToIgnoreCase);
        return textArrayList;
    }

    public ArrayList<String> getWordsContainingSubstring(String substring) throws NoSuchElementException {
            ArrayList<String> textArrayList = getText();
            ArrayList<String> containerList = textArrayList.stream()
                    .filter(w -> w.toLowerCase().contains(substring.toLowerCase()))
                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
            if (containerList.size() > 0) {
                return containerList;
            } else {
                throw new NoSuchElementException("Can't find substring in the text");
            }
    }

    public ArrayList<String> getStringsWhichPalindromes() {
        ArrayList<String> textArrayList = getText();
        ArrayList<String> newList = removeDuplicates(textArrayList);
        ArrayList<String> palindromes = new ArrayList<>();
        for (String word : newList) {
            for (String checkedWord : newList) {
                if (word.toLowerCase().equals(reverseString(checkedWord.toLowerCase()))) {
                    palindromes.add(word);
                    palindromes.add(checkedWord);
                }
            }
        }
        return palindromes;
    }

    private ArrayList<String> getText() {
        String textString = text != null ? text.readLines() : null;
        return new ArrayList<>(Arrays.asList(textString != null ? textString.split(" ") : new String[0]));
    }

    private ArrayList<String> removeDuplicates(ArrayList<String> originalList) {
        ArrayList<String> newList = new ArrayList<>();
        for (String element : originalList) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }

    private String reverseString(String word) {
        StringBuilder reversedWord = new StringBuilder();
        reversedWord.append(word);
        reversedWord = reversedWord.reverse();
        return reversedWord.toString();
    }

}