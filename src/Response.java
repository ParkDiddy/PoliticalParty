import java.util.ArrayList;

public class Response {
    private ArrayList<String> responseList;

    public Response() {
        this.responseList = new ArrayList<>();
    }

    public void add(String response) {
        this.responseList.add(response);
    }

    public String toString() {
        StringBuilder allResponseString = new StringBuilder();
        for (String response : this.responseList) {
            allResponseString.append(response);
            allResponseString.append("\n");
        }
        return allResponseString.toString();
    }
}
