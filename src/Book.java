/**
 * Book object of type Item.
 */
public class Book extends Item {
    /**
     * Number of pages in the book.
     */
    private final int numPages;
    /**
     * Author of the book.
     */
    private final String author;

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
