package com.gsonkeno.english.learn.repository;

import com.gsonkeno.english.learn.model.WordDescription;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WordRepository {

    private static List<WordDescription> wordList = new ArrayList<>();

    static {
        URL wordFileURL = WordRepository.class.getClassLoader().getResource("强化词汇V2.csv");
        File file = null;
        try {
            file = new File(wordFileURL.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            Row row = iterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            int number = Double.valueOf(cellIterator.next().getNumericCellValue()).intValue();
            String word = cellIterator.next().getStringCellValue();
            String soundMark = cellIterator.next().getStringCellValue();
            String meaning = cellIterator.next().getStringCellValue();

            // list在哪一列不确定
            Cell cell = cellIterator.next();
            String value = cell.getStringCellValue();
            String listIndex;
            if (value != null && value.contains("List")) {
                listIndex = value;
            } else {
                listIndex = cellIterator.next().getStringCellValue();
            }
            int index = listIndex.indexOf("List");
            String listNo = listIndex.substring(index + 4).trim();

            WordDescription wordDesc = new WordDescription(number, word, soundMark, meaning, listIndex, Integer.valueOf(listNo));
            wordList.add(wordDesc);
        }
    }

    public static List<WordDescription> getWordList() {
        return wordList;
    }
}
