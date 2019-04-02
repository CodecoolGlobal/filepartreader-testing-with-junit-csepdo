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
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read(String filePath) {
        ArrayList<String> tempList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                tempList.add(sCurrentLine);
            }
            String wholeText = tempList.toString();
            return wholeText;
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String readLines() {
        String wholeText = read(this.filePath);
        String separator = (System.getProperty("os.name").startsWith("windows")) ? "\n" : "\r\n";
        String[] tempArray = wholeText.split(separator);
        ArrayList<String> filePartList = new ArrayList<>();
        filePartList.addAll(Arrays.asList(tempArray).subList(fromLine, toLine + 1));
        filePart = filePartList.toString();
        return filePart;
    }

}
