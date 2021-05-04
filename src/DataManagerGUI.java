import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class DataManagerGUI {
    private static HashMap<Integer, Item> library;
    private static LinkedList<Book> bookCollection;
    private static LinkedList<Music> musicCollection;
    private static LinkedList<Movie> movieCollection;
    private static Scanner scan;
    private static int id;
    private static String type;


    public DataManagerGUI() {
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
            if ((library.get(id).getCopies() >= 1)) {
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
            System.out.printf("%s Number of copies: %d%n", library.get(id).getName(), library.get(id).getCopies());
        }
    }

    public static void getItemType() {
        //Gets user selection.
        System.out.print("Would you like to see \nBooks,\nMovies, \nor Music\n(Books, Movies, Music)? ");
        type = scan.nextLine().toLowerCase();
        System.out.println();

        //If invalid string.
        while (!type.equals("books") && !type.equals("movies") && !type.equals("music")) {
            System.out.print("Invalid Option\nWould you like to see \nBooks,\nMovies, \n or Music\n(Books, Movies, Music)? ");
            type = scan.nextLine().toLowerCase();
            System.out.println();
        }

        //Prints inventory based on item type.
        switch (type) {
            case "books":
                for (Book book : bookCollection) {
                    System.out.printf("ID: %d, %s, %s, Genre: %s, Number of Pages: %d, Number of Copies: %d%n%n", book.getId(), book.getName(), book.getAuthor(), book.getGenre(), book.getNumPages(), book.getCopies());
                }
                break;

            case "movies":
                for (Movie movie : movieCollection) {
                    System.out.printf("ID: %d, %s, Genre: %s, Number of Minutes: %d, Number of Copies: %d%n%n", movie.getId(), movie.getName(), movie.getGenre(), movie.getLengthMinutes(), movie.getCopies());
                }
                break;

            case "music":
                for (Music music : musicCollection) {
                    System.out.printf("ID: %d, Album: %s, Artist: %s, Genre: %s, Number of Songs: %d, Number of Copies: %d%n%n", music.getId(), music.getName(), music.getArtist(), music.getGenre(), music.getNumSongs(), music.getCopies());
                }
                break;
            default:
                System.out.println("Invalid Type!");
        }
    }

    /**
     * Loads item data from a file.
     */
    public static void loadFile() {
        String filename = "";
        String[] line;
        int id;
        Scanner fileReader;
        //Gets filename from JFileChooser.
        JFileChooser fileChooser = new JFileChooser(".");
        int status = fileChooser.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {
            filename = fileChooser.getSelectedFile().getPath();
        }
        if (status == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "No File loaded.", "", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        //If invalid file.
        while (!new File(filename).exists()) {
            JOptionPane.showMessageDialog(null, "Invalid File!", "", JOptionPane.ERROR_MESSAGE);
            status = fileChooser.showOpenDialog(null);
            if (status == JFileChooser.APPROVE_OPTION) {
                filename = fileChooser.getSelectedFile().getPath();
            }
            if (status == JFileChooser.CANCEL_OPTION)
                JOptionPane.showMessageDialog(null, "No File loaded.", "", JOptionPane.INFORMATION_MESSAGE);
                return;
        }
        try {
            fileReader = new Scanner(new File(filename));
            fileReader.useDelimiter(",");

            //While file has lines, read!
            while (fileReader.hasNextLine()) {
                line = fileReader.nextLine().split(",");
                id = Integer.parseInt(line[0]);
                type = line[1];

                //Determines Object type
                switch (type) {
                    case "Book" -> {
                        Book tempBook = new Book(id, line[2], line[3], line[4], Integer.parseInt(line[5]), Integer.parseInt(line[6]));
                        library.put(id, tempBook);
                        bookCollection.add(tempBook);
                    }
                    case "Movie" -> {
                        Movie tempMovie = new Movie(id, line[2], line[3], Integer.parseInt(line[4]), Integer.parseInt(line[5]));
                        library.put(id, tempMovie);
                        movieCollection.add(tempMovie);
                    }
                    case "Music" -> {
                        Music tempMusic = new Music(id, line[2], line[3], line[4], Integer.parseInt(line[5]), Integer.parseInt(line[6]));
                        library.put(id, tempMusic);
                        musicCollection.add(tempMusic);
                    }
                }
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
        System.out.print("Enter a file name to save to: ");
        try {
            PrintWriter pw = new PrintWriter(scan.nextLine());
            System.out.println();

            //Prints all books, movies, and music into file.

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
        //Prompts user for id number.
        System.out.print("Enter the item's id: ");
        id = scan.nextInt();
        scan.nextLine();
        System.out.println();

        //If id number is null return false.
        if (library.get(id) == null) {
            System.out.println("Invalid item ID!");
            return false;

            //Else id number must be in library, therefore return true.
        } else {
            return true;
        }
    }
}
