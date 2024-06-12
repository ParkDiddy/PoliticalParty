import java.util.Scanner;

public class UserInterface {

    public void startProgram() {
        Scanner scanner = new Scanner(System.in);

        QuestionList newQuestionList = new QuestionList();
        Response responseList = new Response();

        int democrat = 0;
        int republican = 0;
        int libertarian = 0;
        int greenParty = 0;

        newQuestionList.parseCSVQuestionsAndOptions("questions.csv");

        for (Question question : newQuestionList) {
            question.printQuestion();
            int input = Integer.parseInt(scanner.nextLine());
            responseList.add(question.getOption(input));

            switch (input) {
                case 1:
                    democrat++;
                case 2:
                    republican++;
                case 3:
                    libertarian++;
                case 4:
                    greenParty++;
            }
        }

        int max = democrat;
        String maxName = "You most align with the democratic party.";

        if (republican > max) {
            max = republican;
            maxName = "You most align with the republican party.";
        }

        if (libertarian > max) {
            max = libertarian;
            maxName = "You most align with the libertarian party.";
        }

        if (greenParty > max) {
            maxName = "You most align with the green party.";
        }

        System.out.println(maxName);

    }
}
