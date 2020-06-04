import java.util.ArrayList;

public interface IContactsManager {
    void viewContact(ArrayList<Contact> contactsList);
    void addContact(ArrayList<Contact> contactsList);
    void editContact(String phoneNumber, ArrayList<Contact> contactsList);
    void deleteContact(String phoneNumber, ArrayList<Contact> contactsList);
    void findContact(ArrayList<Contact> contactsList);
}
