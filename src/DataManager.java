import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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


    public DataManager() {
        bookCollection = new LinkedList<>();
        musicCollection = new LinkedList<>();
        movieCollection = new LinkedList<>();
        library = new HashMap<>();
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
        System.out.print("Would you like to see \nBooks,\nMovies, \n or Music\n(Books, Movies, Music)? ");
        type = scan.nextLine().toLowerCase();
        System.out.println();
        while (!type.equals("books") && !type.equals("movies") && !type.equals("music")) {
            System.out.print("Invalid Option\nWould you like to see \nBooks,\nMovies, \n or Music\n(Books, Movies, Music)? ");
            type = scan.nextLine().toLowerCase();
            System.out.println();
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

    /**
     * Loads item data from a file.
     */
    public static void loadFile() {
        File file;
        int id;
        System.out.print("Enter a file name to load:");
        file = new File(scan.nextLine());
        System.out.println();
        while (!file.exists()) {
            System.out.print("Enter a file name to load:");
            file = new File(scan.nextLine());
            System.out.println();
        }
        try {
            Scanner fileReader = new Scanner(file);
            fileReader.useDelimiter(",");
            while (fileReader.hasNextLine()) {
                id = fileReader.nextInt();
                type = fileReader.next();
                switch (type) {
                    case "Book" -> {
                        Book tempBook = new Book(id, fileReader.next(), fileReader.next(), fileReader.next(), fileReader.nextInt(), fileReader.nextInt());
                        library.put(id, tempBook);
                        bookCollection.add(tempBook);
                    }
                    case "Movie" -> {
                        Movie tempMovie = new Movie(id, fileReader.next(), fileReader.next(), fileReader.nextInt(), fileReader.nextInt());
                        library.put(id, tempMovie);
                        movieCollection.add(tempMovie);
                    }
                    case "Music" -> {
                        Music tempMusic = new Music(id, fileReader.next(), fileReader.next(), fileReader.next(), fileReader.nextInt(), fileReader.nextInt());
                        library.put(id, tempMusic);
                        musicCollection.add(tempMusic);
                    }
                }
                scan.nextLine();
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * Saves item data to a file.
     */
    public static void saveFile() {
        System.out.print("Enter a file name to save to :");
        try {
            PrintWriter pw = new PrintWriter(scan.nextLine());
            System.out.println();
            for (Book book : bookCollection) {
                pw.printf("%d,Book,%s,%s,%s,%d,%d%n", book.getId(), book.getName(), book.getAuthor(), book.getGenre(), book.getNumPages(), book.getCopies());
            }
            for (Movie movie : movieCollection) {
                pw.printf("%d,Movie,%s,%s,%d,%d%n", movie.getId(), movie.getName(), movie.getGenre(), movie.getLengthMinutes(), movie.getCopies());
            }
            for (Music music : musicCollection) {
                pw.printf("%d,Music,%s,%s,%s,%d,%d%n", music.getId(), music.getName(), music.getArtist(), music.getGenre(), music.getNumSongs(), music.getCopies());
            }
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prompts user for ID number, sets ID number, and checks if valid id number.
     * Returns true if valid id and false if not.
     */
    private static boolean getID() {
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
