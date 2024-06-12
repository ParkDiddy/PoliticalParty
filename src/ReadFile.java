import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReadFile {
    private final String filePath;
    private HashMap<String, Double> responseAndWeight;

    ReadFile(String filePath) {
        this.filePath = filePath;
        this.responseAndWeight = new HashMap<>();
    }

    public void collectWeights() {
        try (Scanner readFile = new Scanner(Paths.get(this.filePath))) {
            while (readFile.hasNextLine()) {
                String response = readFile.nextLine();
                // Here we see if a key already exists. If it does, we add .1 to it to increase its weight since
                // multiple responses have indicated this response correlates with this political party
                if (this.responseAndWeight.get(response) != null) {
                    double weight = this.responseAndWeight.get(response);
                    double weightAdjustment = .1;
                    this.responseAndWeight.put(response, weight + weightAdjustment);
                } else {
                    // Else, we add the response and set its initial weight to .1
                    double weight = .1;
                    this.responseAndWeight.put(response, weight);
                }
            }
        } catch (Exception e) {
            System.out.println("Error!" + e);
        }
    }

    public HashMap<String, Double> getResponseAndWeight() {
        return this.responseAndWeight;
    }
}

