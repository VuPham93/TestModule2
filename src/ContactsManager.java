import java.util.ArrayList;
import java.util.Scanner;

public class ContactsManager implements IContactsManager{
    Scanner scanner = new Scanner(System.in);
    ArrayList<Contact> contactsList = ContactsList.creatContactsList();

    @Override
    public void viewContact(ArrayList<Contact> contactsList) {
        Scanner scanner = new Scanner(System.in);
        for (Contact contact: contactsList) {
            System.out.println(contact.toString());
            scanner.nextLine();
        }
        Menu.displayMenu();
    }

    @Override
    public void addContact(ArrayList<Contact> contactsList) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.println("Group: ");
        String group = scanner.nextLine();

        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        System.out.println("Enter gender: ");
        String gender = scanner.nextLine();

        System.out.println("Enter address: ");
        String address = scanner.nextLine();

        System.out.println("Enter date of birth: ");
        String dateOfBirth = scanner.nextLine();

        System.out.println("Enter email: ");
        String email = scanner.nextLine();

        System.out.println("--------------------------------------");

        String result = this.checkInformation(phoneNumber, group, name, gender, address, dateOfBirth, email);

        if (result.equals("Save completed!")){
            System.out.println(result);

            Contact student = new Contact(phoneNumber, group, name, gender, address, dateOfBirth, email);
            contactsList.add(student);
        }
        else {
            System.out.println(result);
            this.addContact(contactsList);
        }
        Menu.displayMenu();
    }

    @Override
    public void editContact(String phoneNumber, ArrayList<Contact> contactsList) {
        if (checkPhone(phoneNumber, contactsList)!= -1) {
            int index = checkPhone(phoneNumber, contactsList);
            System.out.println("Find " + phoneNumber + " on contacts list");

            System.out.println("Phone Number: ");
            String phone = scanner.nextLine();

            System.out.println("Group: ");
            String group = scanner.nextLine();

            System.out.println("Name: ");
            String name = scanner.nextLine();

            System.out.println("Gender: ");
            String gender = scanner.nextLine();

            System.out.println("Address: ");
            String address = scanner.nextLine();

            System.out.println("Date Of Birth: ");
            String dateOfBirth = scanner.nextLine();

            System.out.println("Email: ");
            String email = scanner.nextLine();

            String result = this.checkInformation(phone, group, name, gender, address, dateOfBirth, email);
            if (result.equals("Save completed!")){
                System.out.println("Save completed!");
                Contact contact = new Contact(phone, group, name, gender, address, dateOfBirth, email);
                contactsList.set(index, contact);
            }
            else {
                System.out.println(result);
            }
            Menu.displayMenu();

        }else {
            System.out.println("Can't find that contact");
            System.out.println("Please enter new phone number");

            String reCheckPhone = scanner.nextLine();
            if (!reCheckPhone.equals("")){
                this.editContact(reCheckPhone, contactsList);
            }
            else {
                Menu.displayMenu();
            }

        }
    }

    @Override
    public void deleteContact(String phoneNumber, ArrayList<Contact> contactsList) {
        if (checkPhone(phoneNumber, contactsList)!=-1){
            System.out.println("You want to delete");
            String accept = scanner.nextLine();
            if (accept.equals("Y")){
                int index = checkPhone(phoneNumber,contactsList);
                System.out.println("Deleted");
                contactsList.remove(index);
            }
            else Menu.displayMenu();

        }
        else {
            System.out.println("Can't find that contact");
            System.out.println("Please enter new phone number");
            String rePhone = scanner.nextLine();
            if (!rePhone.equals("")){
                deleteContact(rePhone,contactsList);
            }
            else Menu.displayMenu();

        }
    }

    @Override
    public void findContact(ArrayList<Contact> contactsList) {
        System.out.println("Moi ban nhap chuc nang tim kiem: ");
        System.out.println("1.Tim theo so dien thoai ");
        System.out.println("2.Tim theo ten ");
        int chose = scanner.nextInt();
        if (chose==1){
            System.out.println("Moi ban nhap vao so dien thoai");
            String phoneSearch = scanner.nextLine();
            if (checkPhone(phoneSearch,contactsList)!=-1){
                int indexPhone = checkPhone(phoneSearch,contactsList);
                displayStudent(indexPhone,contactsList);
            }else System.out.println("Khong tim thay");
        }else if (chose==2){
            System.out.println("Moi ban nhap vao so dien thoai");
            String nameSearch = scanner.nextLine();
            if (checkName(nameSearch,contactsList)!=-1){
                int indexName = checkName(nameSearch,contactsList);
                displayStudent(indexName,contactsList);
            }else System.out.println("Khong tim thay");
        }
    }

    public void displayStudent(int index,ArrayList<Contact> contactsList)  {
        Menu.displayMenu();
    }

    public String checkInformation(String phoneNumber, String group, String name, String gender, String address,String dateOfBirth,String email){
        String result = "";

        if (group.equals("") || name.equals("") || gender.equals("") || address.equals("") || dateOfBirth.equals("") || email.equals("")){
            result = "Please enter information";
        }
        else if (!InputChecker.checkPhoneNumber(phoneNumber)) {
            result = "Wrong phone number type";
        }
        else if (!InputChecker.checkEmail(email)){
            result = "Wrong email type";
        }
        else {
            result = "Save completed!";
        }
        return result;
    }

    public int checkPhone(String phoneNumber, ArrayList<Contact> contacts) {
        int index = -1;
        for (int i = 0; i < contacts.size(); i++) {
            if (phoneNumber.equals(contacts.get(i).getPhoneNumber())) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int checkName(String name, ArrayList<Contact> contacts) {
        int indexName = -1;
        for (int i = 0; i < contacts.size(); i++) {
            if (name.equals(contacts.get(i).getName())) {
                indexName = i;
                break;
            }
        }
        return indexName;
    }
}
