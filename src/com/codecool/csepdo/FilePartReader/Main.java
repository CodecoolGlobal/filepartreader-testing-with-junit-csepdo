package com.codecool.csepdo.FilePartReader;

public class Main {
    public static void main(String[] args) {
        FilePartReader reader = new FilePartReader();
        reader.setup("test.txt", 1, 5);
        reader.read();
        System.out.println(reader.read());
        reader.readLines();
        System.out.println(reader.readLines());

        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        analyzer.getWordsOrderedAlphabetically();
        System.out.println(String.join(" ", analyzer.getWordsOrderedAlphabetically()));
        analyzer.getWordsContainingSubstring("in");
        System.out.println(String.join(" ", analyzer.getWordsContainingSubstring("on")));
    }
}
