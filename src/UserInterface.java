import java.util.HashMap;
import java.util.Scanner;

public class UserInterface {
    public void startProgram() {
        Scanner scanner = new Scanner(System.in);
        QuestionList newQuestionList = new QuestionList();
        Response responseList = new Response();
        // Parse questions and options from a CSV file
        newQuestionList.parseCSVQuestionsAndOptions("questions.txt");
        for (Question question : newQuestionList) {
            question.printQuestion();
            int input = Integer.parseInt(scanner.nextLine());
            responseList.add(question.getOption(input)); // Add the selected option to the response list
        }
        // We'll see what party the user identifies with to store their responses in the relevant csv.
        String politicalParty = responseList.getPoliticalPartyResponse();
        String filePath = responseList.getFilePath(politicalParty);

        WriteFile writeFile = new WriteFile();
        writeFile.writeFile(filePath, responseList.toString());

        // Go through each csv and collect their responses and weights into a hash map to compare the responses to
        ReadFile readFileDemocrat = new ReadFile("democratResponses.csv");
        readFileDemocrat.collectWeights();
        HashMap<String, Double> democratHashMap = readFileDemocrat.getResponseAndWeight();

        ReadFile readFileRepublican = new ReadFile("republicanResponses.csv");
        readFileRepublican.collectWeights();
        HashMap<String, Double> republicanHashMap = readFileRepublican.getResponseAndWeight();

        ReadFile readFileGreen = new ReadFile("greenPartyResponses.csv");
        readFileGreen.collectWeights();
        HashMap<String, Double> greenPartyHashMap = readFileGreen.getResponseAndWeight();

        ReadFile readFileLibertarian = new ReadFile("libertarianResponses.csv");
        readFileLibertarian.collectWeights();
        HashMap<String, Double> libertarianHashMap = readFileLibertarian.getResponseAndWeight();

        double democratScore = 0;
        double republicanScore = 0;
        double greenPartyScore = 0;
        double libertarianScore = 0;

        // Do the comparisons and add the weights to a var.
        for (String response : responseList.getResponseList()) {
            if (democratHashMap.get(response) != null) {
                democratScore += democratHashMap.get(response);
            }
            if (republicanHashMap.get(response) != null) {
                republicanScore += republicanHashMap.get(response);
            }
            if (greenPartyHashMap.get(response) != null) {
                greenPartyScore += greenPartyHashMap.get(response);
            }
            if (libertarianHashMap.get(response) != null) {
                libertarianScore += libertarianHashMap.get(response);
            }
        }

        System.out.println("---");
        
        double maxValue = 0;
        String partyPrediction = "";
        
        if (republicanScore > maxValue) {
            maxValue = republicanScore;
            partyPrediction = "You are most likely a republican.";
        }
        if (democratScore > maxValue) {
            maxValue = democratScore;
            partyPrediction = "You are most likely a democrat.";
        }
        if (greenPartyScore > maxValue) {
            maxValue = greenPartyScore;
            partyPrediction = "You are most likely a green party member.";
        }
        if (libertarianScore > maxValue) {
            partyPrediction = "You are most likely a libertarian.";
        }
        System.out.println(partyPrediction);
    }
}
