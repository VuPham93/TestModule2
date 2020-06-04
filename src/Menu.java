import java.util.Scanner;

public class Menu {
    public static void displayMenu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("------- CONTACTS MANAGER -------");
        System.out.println("Select function by enter number to continue:");
        System.out.println("1. View contacts list");
        System.out.println("2. Add contact");
        System.out.println("3. Update contact");
        System.out.println("4. Delete contact");
        System.out.println("5. Find contact");
        System.out.println("6. Read contacts from file");
        System.out.println("7. Save contacts list to file");
        System.out.println("8. Exit");
        System.out.println("--------------------------------");

        System.out.print("Please select function: ");
    }
}
