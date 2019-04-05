package com.codecool.csepdo.FilePartReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FilePartReader {
    private String filePart;
    private Integer fromLine;
    private Integer toLine;
    private String filePath;

    public FilePartReader() {
        this.filePart = null;
        this.fromLine = null;
        this.toLine = null;
        this.filePath = null;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) throws IllegalArgumentException {
        if (fromLine > 0 && toLine >= fromLine && filePath.length() > 0) {
            this.filePath = filePath;
            this.fromLine = fromLine;
            this.toLine = toLine;
        } else {
            throw new IllegalArgumentException("Invalid line number");
        }
    }

    public String read() {
        ArrayList<String> tempList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.filePath))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                tempList.add(sCurrentLine + "\n");
            }
            String wholeText = String.join(" ", tempList);
            return wholeText;
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String readLines() {
        String wholeText = read();
        String[] tempArray = wholeText.split("\n");
        ArrayList<String> filePartList = new ArrayList<>();
        filePartList.addAll(Arrays.asList(tempArray).subList(fromLine - 1, toLine));
        filePart = String.join("", filePartList);
        return filePart;
    }

}
