import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class QuestionList implements Iterable<Question> {
    private ArrayList<Question> questionList;
    public QuestionList() {
        this.questionList = new ArrayList<>();
    }
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
                ArrayList<String> options = new ArrayList<>();
                options.add(questionsAndOptions[1]);
                options.add(questionsAndOptions[2]);
                options.add(questionsAndOptions[3]);
                options.add(questionsAndOptions[4]);
                Question newQuestion = new Question(question, options);
                this.questionList.add(newQuestion);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }
    public int size() {
        return this.questionList.size();
    }
    @Override
    public Iterator<Question> iterator() {
        return this.questionList.iterator();
    }
}
