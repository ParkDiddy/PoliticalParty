import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class QuestionList implements Iterable<Question> {
    // List to store questions
    private ArrayList<Question> questionList;

    // Constructor to initialize the question list
    public QuestionList() {
        this.questionList = new ArrayList<>();
    }

    // Method to add a question to the list
    public void add(Question question) {
        this.questionList.add(question);
    }

    // Method to parse questions and options from a CSV file and add them to the list
    public void parseCSVQuestionsAndOptions(String filePath) {
        try (Scanner csvReader = new Scanner(Paths.get(filePath))) {
            while (csvReader.hasNextLine()) {
                // Split the line into question and options
                String[] questionsAndOptions = csvReader.nextLine().split(",");
                String question = questionsAndOptions[0];

                // Create a list of options
                ArrayList<String> options = new ArrayList<>();
                options.add(questionsAndOptions[1]);
                options.add(questionsAndOptions[2]);
                options.add(questionsAndOptions[3]);
                options.add(questionsAndOptions[4]);

                // Create a new Question object and add it to the list
                Question newQuestion = new Question(question, options);
                this.questionList.add(newQuestion);
            }
        } catch (Exception e) {
            // Print an error message if an exception occurs
            System.out.println("Error:" + e);
        }
    }

    // Method to get the size of the question list
    public int size() {
        return this.questionList.size();
    }

    // Method to return an iterator for the question list
    @Override
    public Iterator<Question> iterator() {
        return this.questionList.iterator();
    }
}
