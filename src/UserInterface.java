import java.util.Scanner;

/**
 * Command-Line Interface version of the library database management.
 */
public class UserInterface {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int option = 0;
        DataManager library = new DataManager();
        System.out.println("Welcome to the library");
        while (option != 7) {
            System.out.println("What would you like to do?");
            System.out.println("1. Check-out");
            System.out.println("2. Check-in");
            System.out.println("3. Check item availability");
            System.out.println("4. List all items of a particular type");
            System.out.println("5. Load inventory file");
            System.out.println("6. Save inventory file");
            System.out.println("7. Exit program");
            System.out.print("Enter an option (1,2,3,4,5,6, or 7): ");
            option = scan.nextInt();
            System.out.println();
            switch (option) {
                case 1:
                    library.checkOut();
                    break;
                case 2:
                    library.checkIn();
                    break;
                case 3:
                    library.getNumberOfCopies();
                    break;
                case 4:
                    library.getItemType();
                    break;
                case 5:
                    library.loadFile();
                    break;
                case 6:
                    library.saveFile();
                case 7:
                    break;
                default:
                    System.out.println("Invalid Option!");
            }
            System.out.println();
        }

    }
}