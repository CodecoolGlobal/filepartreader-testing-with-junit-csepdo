package com.codecool.csepdo.FilePartReader;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    private static FileWordAnalyzer fileWordAnalyzerTest;

    @BeforeAll
    static void init() {
        FilePartReader filePartReaderTest = new FilePartReader();
        filePartReaderTest.setup("test.txt", 1, 3);
        fileWordAnalyzerTest = new FileWordAnalyzer(filePartReaderTest);
    }

    @DisplayName("Test if the order is correct")
    @Test
    void getWordsOrderedAlphabetically() {
        ArrayList<String> orderedArray = new ArrayList<>(Arrays.asList("did", "did", "Dont", "gym", "I", "I", "My", "nod"));
        assertEquals(orderedArray, fileWordAnalyzerTest.getWordsOrderedAlphabetically());
    }

    @DisplayName("Check if containing strings are correct")
    @Test
    void getWordsContainingSubstring() {
        ArrayList<String> containerListO = new ArrayList<>(Arrays.asList("Dont", "nod"));
        assertEquals(containerListO, fileWordAnalyzerTest.getWordsContainingSubstring("o"));
        ArrayList<String> containerListY = new ArrayList<>(Arrays.asList("My", "gym"));
        assertEquals(containerListY, fileWordAnalyzerTest.getWordsContainingSubstring("y"));

    }

    @DisplayName("Check if found all palindromes")
    @Test
    void getStringsWhichPalindromes() {
        ArrayList<String> palindromeList = new ArrayList<>(Arrays.asList("I", "I", "did", "did"));
        assertEquals(palindromeList, fileWordAnalyzerTest.getStringsWhichPalindromes());
    }
}