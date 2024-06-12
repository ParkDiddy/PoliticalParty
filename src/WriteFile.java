import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class WriteFile {
    public void writeFile(String filePath, String content) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            fileWriter.write(content);
            fileWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred." + e);
        }
    }
}
