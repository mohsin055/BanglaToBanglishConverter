package com.ipv.nlp.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Mohsin Uddin
 */
public class Utils {
             
    public static ArrayList<String> getLineArray(String filename) {

        ArrayList<String> tempList = new ArrayList<>();
        File file = new File(filename);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                tempList.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tempList;
    }

    public static void storeData(String outputFileLocation, String outputText, boolean append) {
        try {

            File file = new File(outputFileLocation);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWritter = new FileWriter(outputFileLocation, append);
            try (BufferedWriter bufferWritter = new BufferedWriter(fileWritter)) {
                bufferWritter.write(outputText);
            }

        } catch (IOException e) {
        }

    }
  
  
    
}
