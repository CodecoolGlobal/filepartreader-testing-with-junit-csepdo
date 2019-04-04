package com.codecool.csepdo.FilePartReader;

import java.util.ArrayList;
import java.util.Arrays;

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

    public ArrayList<String> getWordsContainingSubstring(String substring) {
        ArrayList<String> textArrayList = getText();
        return textArrayList.stream()
                .filter(w -> w.toLowerCase().contains(substring.toLowerCase()))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    private ArrayList<String> getText() {
        String textString = text != null ? text.readLines() : null;
        return new ArrayList<>(Arrays.asList(textString != null ? textString.split(" ") : new String[0]));
    }

    public ArrayList<String> getStringsWhichPalindromes() {
        return null;
    }
}