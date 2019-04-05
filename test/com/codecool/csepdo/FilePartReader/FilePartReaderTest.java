package com.codecool.csepdo.FilePartReader;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FilePartReaderTest {

    private FilePartReader filePartReaderTest = new FilePartReader();

    @DisplayName("Test for invalid line numbers")
    @Test()
    void setupNumbers() {
        assertThrows(IllegalArgumentException.class, () ->
                filePartReaderTest.setup("test.txt", 0, 7));
        assertThrows(IllegalArgumentException.class, () ->
                filePartReaderTest.setup("test.txt", 0, 0));
        assertThrows(IllegalArgumentException.class, () ->
                filePartReaderTest.setup("test.txt", 3, 2));
    }

    @DisplayName("Test for invalid filePath")
    @Test()
    void setupFilePath() {
        assertThrows(IllegalArgumentException.class, () ->
                filePartReaderTest.setup("", 1, 1));
    }

    @DisplayName("Test if substring equals")
    @Test
    void read() {
        filePartReaderTest.setup("test.txt", 1, 1);
        assertEquals("Dont", filePartReaderTest.read().substring(0, 4));
        assertEquals("melon", filePartReaderTest.read().substring(filePartReaderTest.read().length()-6,filePartReaderTest.read().length()-1));
    }

    @DisplayName("Test readlines method")
    @Test
    void readLines() {
        filePartReaderTest.setup("test.txt", 2, 4);
        assertEquals(" I did did I My gym Red rum sir is murder", filePartReaderTest.readLines());
    }
}