package L5_GUI.data;

public class Book extends PrinteredEdition{
    private String genre;
    public Book(String title, String author, int year, int numOfPages, String genre) {
        super(title, author, year, numOfPages);
        this.genre = genre;
    }

    public Book(String title, String author, int year, int numOfPages) {
        super(title, author, year, numOfPages);
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
