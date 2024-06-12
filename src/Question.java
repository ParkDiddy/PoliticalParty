import java.util.ArrayList;

public class Question {

    // Instance variable to store the question text
    private String question;

    // Instance variable to store the list of options
    private ArrayList<String> optionsList;

    // Constructor to initialize the question and options list
    public Question(String question, ArrayList<String> optionsList) {
        this.question = question;
        this.optionsList = optionsList;
    }

    // Method to get the question text
    public String getQuestion() {
        return this.question;
    }

    // Method to get the options list
    public ArrayList<String> getOptionsList() {
        return this.optionsList;
    }

    // Method to get a specific option by index (1-based)
    public String getOption(int index) {
        return this.optionsList.get(index - 1);
    }

    // Method to print the question and its options to the console
    public void printQuestion() {
        System.out.println(this.question);
        for (String option : optionsList) {
            System.out.println(option);
        }
    }
}
