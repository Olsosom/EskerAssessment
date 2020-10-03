
///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:  FileReport.java
// File:             FileReport.java
//
// Author:           Sommer Olson Copyright (2020). All rights reserved.
// Github:           Olsosom
//
//////////////////////////// 80 columns wide //////////////////////////////////
import java.io.*;
import java.util.*;

/**
 * Creates a report about the provided file, giving name, line, character, word,
 * and word frequency based on length in a newly created file, Output.txt.
 *
 * Bugs: Regex currently on line 57 not robust enough to skip empty lines, 
 * or remove parentheses and double or single quotations from words themselves
 *
 * @author Sommer Olson Copyright (2020)
 * @version 1.0
 */
class FileReport {
    public static void main(String[] args) {
        // Initialize Variables
        BufferedReader reader = null;
        BufferedWriter writer = null;
        HashMap<Integer, Integer> wordLength = new HashMap<Integer, Integer>();
        String fName = "";
        int lineCount = 0;
        int charCount = 0;
        int letterCount = 0;
        int figureCount = 0;
        int otherCount = 0;
        int wordCount = 0;

        try {
            // Check if there is an argument
            if (args.length > 0) {
                fName = args[0];
            }

            // Create BufferedReader for input file
            File file = new File(fName);
            FileInputStream fileStream = new FileInputStream(file);
            InputStreamReader input = new InputStreamReader(fileStream);
            reader = new BufferedReader(input);

            // Increase lineCount, charCount, wordCount, etc.
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();

                // Split words into array
                String[] words = line.split("\\s+|,\\s*|\\.\\s*|\\;\\s*");
                wordCount += words.length;

                // Add characters to array to determine letter,
                // digit, and other count
                char[] ch = line.toCharArray();
                for (int i = 0; i < line.length(); i++) {
                    if (Character.isLetter(ch[i]))
                        letterCount++;
                    else if (Character.isDigit(ch[i]))
                        figureCount++;
                    else
                        otherCount++;
                }

                // Add frequency of 1, 2, etc. letter words to HashMap
                for (String word : words) {
                    int curNumber = 0;
                    if (wordLength.get(word.length()) != null)
                        curNumber = wordLength.get(word.length());
                    wordLength.put(word.length(), curNumber + 1);
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            try {
                // Close reader
                if (reader != null)
                    reader.close();
            } catch (IOException e2) {
                System.out.println("Error closing BufferedReader");
                e2.printStackTrace();
            }
        }

        // Write file information to Output.txt
        try {
            File fOut = new File("Output.txt");

            // Create new file if one doesn't already exist
            if (!fOut.exists()) {
                fOut.createNewFile();
            }
            FileWriter fw = new FileWriter(fOut, true);
            writer = new BufferedWriter(fw);

            // Print out file information
            writer.write("\r\nAppend New File Information\r\n");
            writer.write("Filename: " + fName + "\r\n");
            writer.write("Number of lines: " + lineCount + "\r\n");
            writer.write("Number of characters (total): " + charCount + "\r\n");
            writer.write("Number of letters: " + letterCount + "\r\n");
            writer.write("Number of figures: " + figureCount + "\r\n");
            writer.write("Number of other characters: " + otherCount + "\r\n");
            writer.write("Number of words: " + wordCount + "\r\n");

            // Print out contents of HashMap
            for (Map.Entry<Integer, Integer> curEntry : wordLength.entrySet()) {
                // Ignore empty lines that were counted as words
                if (curEntry.getKey() != 0) {
                    if (curEntry.getKey() == 1)
                        writer.write("Number of " + curEntry.getKey() + " letter words: " + curEntry.getValue() + "\r\n");
                    writer.write("Number of " + curEntry.getKey() + " letters words: " + curEntry.getValue() + "\r\n");
                }
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        } finally {
            try {
                // Close writer
                writer.close();
            } catch (Exception e4) {
                System.out.println("Error closing writer");
                e4.printStackTrace();
            }
        }
    }
}