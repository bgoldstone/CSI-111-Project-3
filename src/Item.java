public abstract class Item {
    protected int id;
    protected int copies;;
    protected String name;
    protected String genre;

    public Item(int id, int copies, String name, String genre){
        this.id = id;
        this.copies = copies;
        this.name = name;
        this.genre = genre;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCopies() {
        return this.copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
