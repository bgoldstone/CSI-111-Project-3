import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Tells {@link TabbedGUI} what to do if certain menu option is hit.
 */
public class DataManagerTabbedGUI {
    private HashMap<Integer, Item> library;
    private LinkedList<Book> bookCollection;
    private LinkedList<Music> musicCollection;
    private LinkedList<Movie> movieCollection;
    private int id;
    private String type;
    private StringBuilder itemList;
    private boolean isLoaded = false;
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File (*.txt)", "txt");


    public DataManagerTabbedGUI() {
        bookCollection = new LinkedList<>();
        musicCollection = new LinkedList<>();
        movieCollection = new LinkedList<>();
        library = new HashMap<>();
        itemList = new StringBuilder();
    }

    /**
     * Sets ID number
     *
     * @param id ID number
     */
    public void setId(int id) {
        this.id = id;
        if (library.get(id) == null) {
            JOptionPane.showMessageDialog(null, "Invalid ID Number!", "", JOptionPane.ERROR_MESSAGE);
            this.id = 0;
        }
    }

    /**
     * Attempts to check-in an item.
     */
    public void checkIn() {
        //Gets and Checks ID.
        if (!isLoaded) {
            JOptionPane.showMessageDialog(null, "No File is loaded!", "", JOptionPane.ERROR_MESSAGE);
            return;
        }

        library.get(id).setCopies(library.get(id).getCopies() + 1);
        JOptionPane.showMessageDialog(null, "Successfully checked in " + library.get(id).getName() + "!", "", JOptionPane.INFORMATION_MESSAGE);
        id = 0;
    }

    /**
     * Attempts to check-out an item.
     */
    public void checkOut() {
        //Gets and Checks ID.
        if (!isLoaded) {
            JOptionPane.showMessageDialog(null, "No File is loaded!", "", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Checks if has any copies
        if ((library.get(id).getCopies() >= 1)) {
            library.get(id).setCopies(library.get(id).getCopies() - 1);
            JOptionPane.showMessageDialog(null, "Successfully checked out " + library.get(id).getName() + "!", "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Not enough copies of " + library.get(id).getName() + "!", "", JOptionPane.ERROR_MESSAGE);
        }
        id = 0;
    }

    /**
     * Gets number of Copies of Item.
     */
    public String getNumberOfCopies() {
        //Prints name and number of copies.
        if (!isLoaded) {
            JOptionPane.showMessageDialog(null, "No File is loaded!", "", JOptionPane.ERROR_MESSAGE);
            return " ";
        } else {
            return library.get(id).getName() + " Number of copies: " + library.get(id).getCopies() + "!";
        }

    }

    public String getItemType(String type) {
        if (!isLoaded) {
            JOptionPane.showMessageDialog(null, "No File is loaded!", "", JOptionPane.ERROR_MESSAGE);
            return "";
        }

        //Gets user selection.
        //Prints inventory based on item type.
        itemList.delete(0, itemList.length());
        switch (type.toLowerCase()) {
            case "books":
                for (Book book : bookCollection) {
                    itemList.append(String.format("ID: %d, %s, %s, Genre: %s, Number of Pages: %d, Number of Copies: %d%n%n", book.getId(), book.getName(), book.getAuthor(), book.getGenre(), book.getNumPages(), book.getCopies()));
                }
                break;

            case "movies":
                for (Movie movie : movieCollection) {
                    itemList.append(String.format("ID: %d, %s, Genre: %s, Number of Minutes: %d, Number of Copies: %d%n%n", movie.getId(), movie.getName(), movie.getGenre(), movie.getLengthMinutes(), movie.getCopies()));
                }
                break;

            case "music":
                for (Music music : musicCollection) {
                    itemList.append(String.format("ID: %d, Album: %s, Artist: %s, Genre: %s, Number of Songs: %d, Number of Copies: %d%n%n", music.getId(), music.getName(), music.getArtist(), music.getGenre(), music.getNumSongs(), music.getCopies()));
                }
                break;
        }
        return itemList.toString();
    }

    /**
     * Loads item data from a file.
     */
    public void loadFile() {
        String filename = "";
        String[] line;
        int id;
        Scanner fileReader;
        //Gets filename from JFileChooser.
        JFileChooser fileChooser = new JFileChooser(".");
        fileChooser.setFileFilter(filter);
        int status = fileChooser.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {
            filename = fileChooser.getSelectedFile().getPath();
        }
        if (status == JFileChooser.CANCEL_OPTION) {
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
                if (line.length != 7 && type.equals("Book"))
                    throw new IndexOutOfBoundsException();
                if (line.length != 6 && type.equals("Movie"))
                    throw new IndexOutOfBoundsException();
                if (line.length != 7 && type.equals("Music"))
                    throw new IndexOutOfBoundsException();
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
        } catch (NumberFormatException | NullPointerException | IndexOutOfBoundsException exception) {
            JOptionPane.showMessageDialog(null, "Invalid File", "", JOptionPane.ERROR_MESSAGE);
        }
        isLoaded = true;
    }

    /**
     * Saves item data to a file.
     */
    public void saveFile() {
        if (!isLoaded) {
            JOptionPane.showMessageDialog(null, "No File is loaded!", "", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String fileName = "";
        JFileChooser fileChooser = new JFileChooser(".");

        //Filters file types to save
        fileChooser.setFileFilter(filter);
        int status = fileChooser.showSaveDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {
            fileName = fileChooser.getSelectedFile().getPath();
        }
        if (status == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "No File saved.", "", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            //Gets file name and extension.
            PrintWriter pw = new PrintWriter(fileName + "." + filter.getExtensions()[0]);

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
}
