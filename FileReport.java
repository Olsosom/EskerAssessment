import java.io.*;

class FileReport {
    public static void main(String[] args) {
        BufferedReader reader = null;
        String fName = "";
        
        try {
            if (args.length > 0) {
                fName = args[0];
                reader = new BufferedReader(new FileReader(fName));
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
                System.out.println("Error in closing BufferedReader");
            }
        }

        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("Output.txt"), "utf-8"));

            writer.write("Filename: " + fName + "\r\n");
            writer.write("Number of lines: " + "\r\n");
            writer.write("Number of characters (total): " + "\r\n");
            writer.write("Number of letters: " + "\r\n");
            writer.write("Number of figures: " + "\r\n");
            writer.write("Number of other characters: " + "\r\n");
            writer.write("Number of words: " + "\r\n");
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