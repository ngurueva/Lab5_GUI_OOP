package L5_GUI.data;

public class Magazine extends PrinteredEdition {

    private int issueNumber;
    public Magazine(String title, String author, int year, int numOfPages, int issueNumber) {
        super(title, author, year, numOfPages);
        this.issueNumber = issueNumber;
    }
    public int getIssueNumber() {
        return issueNumber;
    }
    public void setIssueNum(int issueNum) {
        this.issueNumber = issueNum;
    }
}
