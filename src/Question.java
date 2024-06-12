import java.util.ArrayList;

public class Question {
    private String question;
    private ArrayList<String> optionsList;
    public Question(String question, ArrayList<String> optionsList) {
        this.question = question;
        this.optionsList = optionsList;
    }
    public String getQuestion() {
        return this.question;
    }
    public ArrayList<String> getOptionsList() {
        return this.optionsList;
    }
    public String getOption(int index) {
        return this.optionsList.get(index - 1);
    }
    public void printQuestion() {
        System.out.println(this.question);
        for (String option : optionsList) {
            System.out.println(option);
        }
    }
}
