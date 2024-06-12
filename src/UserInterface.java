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
        // Parse questions and options from a CSV file
        newQuestionList.parseCSVQuestionsAndOptions("questions.txt");
        for (Question question : newQuestionList) {
            question.printQuestion();
            int input = Integer.parseInt(scanner.nextLine());
            responseList.add(question.getOption(input)); // Add the selected option to the response list
            // Increment the appropriate party counter based on user input
//            switch (input) {
//                case 1:
//                    democrat++;
//                case 2:
//                    republican++;
//                case 3:
//                    libertarian++;
//                case 4:
//                    greenParty++;
//            }
        }
        // We'll see what party the user identifies with to store their responses in the relevant csv.
        String politicalParty = responseList.getPoliticalPartyResponse();
//
//        // Determine which party the user aligns with the most
//        int max = democrat;
//        String maxName = "You most align with the democratic party.";
//
//        if (republican > max) {
//            max = republican;
//            maxName = "You most align with the republican party.";
//        }
//        if (libertarian > max) {
//            max = libertarian;
//            maxName = "You most align with the libertarian party.";
//        }
//        if (greenParty > max) {
//            maxName = "You most align with the green party.";
//        }
        // Print the result
//        System.out.println(maxName);
    }
}
