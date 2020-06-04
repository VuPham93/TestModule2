import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int choice;
        ContactsManager contactsManager = new ContactsManager();
        FileReaderAndWriter fileReaderAndWriter = new FileReaderAndWriter();
        ArrayList<Contact> contacts = ContactsList.creatContactsList();

        Menu.displayMenu();

        do {

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    contactsManager.viewContact(contacts);
                    break;
                case 2:
                    contactsManager.addContact(contacts);
                    break;
                case 3:
                    System.out.print("Please enter phone number:");
                    contactsManager.editContact(scanner.nextLine(), contacts);
                    break;
                case 4:
                    System.out.print("Please enter phone number:");
                    contactsManager.deleteContact(scanner.nextLine(), contacts);
                    break;
                case 5:
                    contactsManager.findContact(contacts);
                    break;
                case 6:
                    fileReaderAndWriter.readFile(contacts);
                    break;
                case 7:
                    fileReaderAndWriter.writeFile(contacts);
                    break;
                case 8:
                    break;
            }

        } while (choice != 8);
    }
}
