import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class DataManager {
    private static HashMap<Integer, Item> library;
    private static LinkedList<Book> bookCollection;
    private static LinkedList<Music> musicCollection;
    private static LinkedList<Movie> movieCollection;
    private static Scanner scan;
    private static int id;
    private static String type;
    private static Book tempBook;
    private static Music tempMusic;
    private static Movie tempMovie;


    public DataManager() {
        this.bookCollection = new LinkedList<>();
        this.musicCollection = new LinkedList<>();
        this.movieCollection = new LinkedList<>();
        this.library = new HashMap<>();
        scan = new Scanner(System.in);
    }

    /**
     * Attempts to check-in an item.
     */
    public static void checkIn() {
        //Gets and Checks ID.
        if (getID()) {
            library.get(id).setCopies(library.get(id).getCopies() + 1);
            System.out.printf("Successfully checked in %s!%n", library.get(id).getName());
        }
    }

    /**
     * Attempts to check-out an item.
     */
    public static void checkOut() {
        //Gets and Checks ID.
        if (getID()) {

            //Checks if has any copies
            if (!(library.get(id).getCopies() >= 1)) {
                library.get(id).setCopies(library.get(id).getCopies() - 1);
                System.out.printf("Successfully checked out %s!%n", library.get(id).getName());
            } else {
                System.out.printf("Not enough copies of %s!%n", library.get(id).getName());
            }
        }

    }

    /**
     * Gets number of Copies of Item.
     */
    public static void getNumberOfCopies() {
        //Prints name and number of copies.
        if (getID()) {
            System.out.printf("%s  Number of copies: %d", library.get(id).getName(), library.get(id).getCopies());
        }
    }

    public static void getItemType() {
        type = "";
        while (type != "books" && type != "movies" && type != "music") {
            System.out.print("Would you like to see \nBooks,\nMovies, \n or Music\n(Books, Movies, Music)? ");
            type = scan.nextLine().toLowerCase();
        }
        switch (scan.nextLine()) {
            case "Books":
                for (Book book : bookCollection) {
                    System.out.printf("%s by %s Genre: %s Number of Copies: %d Number of Pages: %d %n", book.getName(), book.getAuthor(), book.getGenre(), book.getCopies(), book.getNumPages());
                }
                break;

            case "Movies":
                for (Movie movie : movieCollection) {
                    System.out.printf("%s Genre: %s Number of Copies: %d Number of Minutes: %d %n", movie.getName(), movie.getGenre(), movie.getCopies(), movie.getLengthMinutes());
                }
                break;

            case "Music":
                for (Music music : musicCollection) {
                    System.out.printf("Album: %s Artist: %s Genre: %s Number of Copies: %d Number of Songs: %d %n", music.getName(), music.getArtist(), music.getGenre(), music.getCopies(), music.getNumSongs());
                }
                break;
        }
    }

    public static void loadFile() {
        File file;
        int id;
        int Name;
        System.out.print("Enter a file name:");
        file = new File(scan.nextLine());
        System.out.println();
        while (!file.exists()) {
            System.out.print("Enter a file name:");
            file = new File(scan.nextLine());
            System.out.println();
        }
        try {
            Scanner fileReader = new Scanner(file);
            fileReader.useDelimiter(",");
            while (fileReader.hasNextLine()) {
                id = fileReader.nextInt();
                type = fileReader.next();
                if (type == "Book") {
                    tempBook = new Book(id, fileReader.next(), fileReader.next(), fileReader.next(), fileReader.nextInt(), fileReader.nextInt());
                    library.put(id, tempBook);
                    bookCollection.add(tempBook);

                } else if (type == "Movie") {
                    tempMovie = new Movie(id, fileReader.next(), fileReader.next(), fileReader.nextInt(), fileReader.nextInt());
                    library.put(id, tempMovie);
                    movieCollection.add(tempMovie);
                    
                } else if (type == "Music") {
                    tempMusic = new Music(id, fileReader.next(), fileReader.next(), fileReader.next(), fileReader.nextInt(), fileReader.nextInt());
                    library.put(id, tempMusic);
                    musicCollection.add(tempMusic);

                }
                scan.nextLine();
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * Prompts user for ID number, sets ID number, and checks if valid id number.
     * Returns true if valid id and false if not.
     */
    public static boolean getID() {
        System.out.print("Enter the item's id: ");
        id = scan.nextInt();
        scan.nextLine();
        System.out.println();

        if (library.get(id) == null) {
            System.out.println("Invalid item ID!");
            return false;
        } else {
            return true;
        }
    }
}

/*
if(library.get(id) instanceof Book){

        }else if(library.get(id) instanceof Movie){

        } else if(library.get(id) instanceof Music){

        }else{
            System.out.println("Not an item!");
        }
 */