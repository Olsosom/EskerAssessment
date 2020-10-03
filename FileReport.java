import java.io.*;
import java.util.*;

class FileReport {
    public static void main(String[] args) {
        BufferedReader reader = null;
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

            String line;

            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                String[] words = line.split(" ");
                wordCount += words.length;

                for (String word : words) {
                    int curNumber = 0;
                    if (wordLength.get(word.length()) != null)
                        curNumber = wordLength.get(word.length());
                    wordLength.put(word.length(), curNumber + 1);
                }
            }


        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (reader != null)
                    reader.close();
            }
            catch (IOException e2) {
                System.out.println("Error closing BufferedReader");
            }
        }

        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("Output.txt"), "utf-8"));

            // Print out file information
            writer.write("Filename: " + fName + "\r\n");
            writer.write("Number of lines: " + lineCount + "\r\n");
            writer.write("Number of characters (total): " + charCount + "\r\n");
            writer.write("Number of letters: " + letterCount + "\r\n");
            writer.write("Number of figures: " + figureCount + "\r\n");
            writer.write("Number of other characters: " + otherCount + "\r\n");
            writer.write("Number of words: " + wordCount + "\r\n");

            // Print out contents of HashMap
            for (Map.Entry<Integer, Integer> curEntry : wordLength.entrySet()) {
                writer.write("Number of " + curEntry.getKey() + " letter words: " 
                    + curEntry.getValue() + "\r\n");
            }
        }
        catch (IOException e3) {

        }
        finally {
            try {
                writer.close();
            }
            catch (Exception e4) {

            }
        }
    }
}