import java.util.ArrayList;

public class Response {
    // List to store responses
    private ArrayList<String> responseList;

    // Constructor to initialize the response list
    public Response() {
        this.responseList = new ArrayList<>();
    }

    // Method to add a response to the list
    public void add(String response) {
        this.responseList.add(response);
    }

    // Method to return a string representation of all responses
    @Override
    public String toString() {
        StringBuilder allResponseString = new StringBuilder();
        // Append each response to the StringBuilder, followed by a newline
        for (String response : this.responseList) {
            allResponseString.append(response);
            allResponseString.append("\n");
        }
        return allResponseString.toString();
    }
}
