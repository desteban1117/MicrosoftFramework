package pojos;

public class Search {

    private String search;
    private String result;
    private int resultNumber;

    public Search(String search, String result, int resultNumber) {
        this.search = search;
        this.result = result;
        this.resultNumber = resultNumber;
    }

    public String getSearch() {
        return search;
    }

    public String getResult() {
        return result;
    }

    public int getResultNumber() {
        return resultNumber;
    }
}
