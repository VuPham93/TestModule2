import java.util.ArrayList;

public class ContactsList {

    public static ArrayList<Contact> creatContactsList() {
        ArrayList<Contact> contacts = new ArrayList<>();

        Contact contact1 = new Contact("0978-565-161", "Family", "Dad", "Male", "Ha Dong - Ha Noi", "12-8-1956", "dadmail.56@gmail.com");
        Contact contact2 = new Contact("0399-301-856", "Family", "Mom", "Female", "Ha Dong - Ha Noi", "08-09-1960", "mommail.60@gmail.com");
        Contact contact3 = new Contact("0353-521-595", "Family", "Sister", "Female", "Kien Hung - Ha Noi", "08-2-1991", "sistermail.91@gmail.com");
        Contact contact4 = new Contact("0333-211-430", "CodeGym", "Lien", "Male", "Y Yen - Nam Dinh", "28-5-1989", "lien89@gmail.com");
        Contact contact5 = new Contact("0543-865-733", "Friend", "Tung", "Male", "Bac Giang", "11-7-1992", "tung.chuba92@gmail.com");

        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        contacts.add(contact4);
        contacts.add(contact5);

        return contacts;
    }
}
