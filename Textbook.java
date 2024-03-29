package L5_GUI.data;

public class Textbook extends Book {
    private String studyArea;

    public Textbook(String title, String author, int year, int numOfPages, String studyArea) {
        super(title, author, year, numOfPages);
        this.studyArea = studyArea;
        this.setGenre("Учебная литература");

    }
    public String getStudyArea() {
        return studyArea;
    }
    public void setStudyArea(String studyArea) {
        this.studyArea = studyArea;
    }
}
