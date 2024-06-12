import java.util.Scanner;

public class UserInterface {

    // Method to start the program
    public void startProgram() {
        Scanner scanner = new Scanner(System.in);

        // Create instances of QuestionList and Response
        QuestionList newQuestionList = new QuestionList();
        Response responseList = new Response();

        // Variables to track alignment with different parties
        int democrat = 0;
        int republican = 0;
        int libertarian = 0;
        int greenParty = 0;

        // Parse questions and options from a CSV file
        newQuestionList.parseCSVQuestionsAndOptions("questions.csv");

        // Iterate through each question in the list
        for (Question question : newQuestionList) {
            question.printQuestion(); // Print the question and its options
            int input = Integer.parseInt(scanner.nextLine()); // Get user input
            responseList.add(question.getOption(input)); // Add the selected option to the response list

            // Increment the appropriate party counter based on user input
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

        // Determine which party the user aligns with the most
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

        // Print the result
        System.out.println(maxName);
    }
}
