import java.util.Scanner;

public class UserInterface {

    public void startProgram() {
        Scanner scanner = new Scanner(System.in);

        QuestionList newQuestionList = new QuestionList();
        Response responseList = new Response();

        newQuestionList.parseCSVQuestionsAndOptions("questions.csv");

        for (Question question : newQuestionList) {
            question.printQuestion();
            int input = Integer.parseInt(scanner.nextLine());
            responseList.add(question.getOption(input));
        }
        System.out.println("----");
        System.out.println(responseList);
    }
}
