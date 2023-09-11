package com.gsonkeno.english.learn;

import com.gsonkeno.english.learn.model.WordDescription;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileReadTest {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/ruchen/Downloads/强化词汇V2.csv");
//        FileReader fileReader = new FileReader(file);
//        BufferedReader bf = new BufferedReader(fileReader);
//        String s = bf.readLine();
//        System.out.println(s);

        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = sheet.iterator();
        List<WordDescription> wordList = new ArrayList<>();
        while (iterator.hasNext()){
            Row row = iterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            int number = Double.valueOf(cellIterator.next().getNumericCellValue()).intValue();
            String word = cellIterator.next().getStringCellValue();
            String soundMark = cellIterator.next().getStringCellValue();
            String meaning = cellIterator.next().getStringCellValue();
            String listIndex = cellIterator.next().getStringCellValue();
            WordDescription wordDesc = new WordDescription(number, word, soundMark, meaning, listIndex);
            wordList.add(wordDesc);

        }
        System.out.println(wordList.size());
    }

}
