/**
 * Book object of type Item.
 */
public class Book extends Item {
    /**
     * Number of pages in the book.
     */
    private int numPages;
    /**
     * Author of the book.
     */
    private String author;

    /**
     * Book Constructor.
     *
     * @param id       ID number of book
     * @param copies   Number of copies of book
     * @param name     Name of book
     * @param genre    Genre of book
     * @param numPages Number of Pages in book
     * @param author   Author of book
     */
    public Book(int id, String name, String author, String genre, int numPages, int copies) {
        // Calls Item Constructor
        super(id, copies, name, genre);
        this.numPages = numPages;
        this.author = author;
    }

    /**
     * Sets Number of pages in book.
     *
     * @param numPages Number of pages
     */
    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    /**
     * Sets Author of book.
     *
     * @param author Author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets Number of pages in a book.
     *
     * @return Number of pages
     */
    public int getNumPages() {
        return this.numPages;
    }

    /**
     * Gets Author of a book.
     *
     * @return Author
     */
    public String getAuthor() {
        return this.author;
    }
}
