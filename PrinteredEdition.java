package L5_GUI.data;

public abstract class PrinteredEdition {
    protected String title;
    protected String author;
    protected int year;
    protected int numOfPages;
    public PrinteredEdition(String title, String author, int year, int numOfPages) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.numOfPages = numOfPages;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setGenre(String aValue) {
    }

    public void setStudyArea(String aValue) {
    }

    public void setIssueNum(int i) {
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getType(){
        Class<?> cls = getClass();
        return cls.getName();
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }
}
