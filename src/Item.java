/*
    Name: Ben Goldstone
    Date: 5/14/2021
    Instructor: Professor Joseph Helsing
 */
/**
 * Item Superclass.
 */
public abstract class Item {
    protected int id;
    protected int copies;
    protected String name;
    protected String genre;

    /**
     * Item Constructor
     *
     * @param id     Media ID
     * @param copies Number of copies in database
     * @param name   Name of media
     * @param genre  Genre of media
     */
    public Item(int id, int copies, String name, String genre) {
        this.id = id;
        this.copies = copies;
        this.name = name;
        this.genre = genre;
    }

    /**
     * Gets media ID.
     *
     * @return ID
     */
    public int getId() {
        return this.id;
    }

    /**
     * Gets number of copies.
     *
     * @return Number of copies
     */
    public int getCopies() {
        return this.copies;
    }

    /**
     * Sets number of copies.
     *
     * @param copies Number of copies
     */
    public void setCopies(int copies) {
        this.copies = copies;
    }

    /**
     * Gets name of media.
     *
     * @return Name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets genre of media.
     *
     * @return Genre
     */
    public String getGenre() {
        return this.genre;
    }

}
