import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int option = 0;
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
                    DataManager.checkOut();
                    break;
                case 2:
                    DataManager.checkIn();
                    break;
                case 3:
                    DataManager.getNumberOfCopies();
                    break;
                case 4:
                    DataManager.getItemType();
                    break;
                case 5:
                    DataManager.loadFile();
                    break;
                case 6:
                    DataManager.saveFile();
                case 7:
                    break;
                default:
                    System.out.println("Invalid Option!");
            }
        }

    }
}

/*
Check-out an item
Check-in an item
Checking item availability
List all information for a particular type of item
Load the inventory file
Save the inventory file
Exit the program
 */