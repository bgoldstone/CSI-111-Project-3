public class Book extends Item {
    private int numPages;
    private String author;

    public Book(int id, int copies, String name, String genre, int numPages, String author) {
        super(id, copies, name, genre);
        this.numPages = numPages;
        this.author = author;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumPages() {
        return this.numPages;
    }

    public String getAuthor() {
        return this.author;
    }

}
