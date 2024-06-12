import java.util.ArrayList;

public class Response {
    private ArrayList<String> responseList;
    public Response() {
        this.responseList = new ArrayList<>();
    }
    public void add(String response) {
        this.responseList.add(response);
    }
    @Override
    public String toString() {
        StringBuilder allResponseString = new StringBuilder();
        for (String response : this.responseList) {
            allResponseString.append(response);
            allResponseString.append("\n");
        }
        return allResponseString.toString();
    }
    public String getPoliticalPartyResponse() {
        return this.responseList.get(this.responseList.size() - 1);
    }
    public String getFilePath(String party) {
        String filePath = null;
        if (party.contains("Democrat")) {
            filePath = "democratResponses.csv";
        } else if (party.contains("Republican")) {
            filePath = "republicanResponses.csv";
        } else if (party.contains("Libertarian")) {
            filePath = "libertarianResponses.csv";
        } else if (party.contains("Green Party")) {
            filePath = "greenPartyResponses.csv";
        }
        return filePath;
    }
}
