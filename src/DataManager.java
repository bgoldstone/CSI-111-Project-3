import java.util.HashMap;
import java.util.LinkedList;

public class DataManager {
    private HashMap<Item,LinkedList> library;
    private LinkedList<Book> books;
    private LinkedList<Music> music;
    private LinkedList<Movie> movies;
    public DataManager(){
        this.books = new LinkedList<>();
        this.music = new LinkedList<>();
        this.movies = new LinkedList<>();
        this.library = new HashMap<>();
    }
}
