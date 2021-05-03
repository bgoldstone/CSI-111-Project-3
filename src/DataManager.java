import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class DataManager {
    private HashMap<Integer, Item> library;
    private LinkedList<Book> books;
    private LinkedList<Music> music;
    private LinkedList<Movie> movies;
    private Scanner scan;

    public DataManager() {
        this.books = new LinkedList<>();
        this.music = new LinkedList<>();
        this.movies = new LinkedList<>();
        this.library = new HashMap<>();
        this.scan = new Scanner(System.in);
    }
}
