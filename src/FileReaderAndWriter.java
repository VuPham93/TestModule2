import java.io.*;
import java.util.ArrayList;

public class FileReaderAndWriter {
    private static final String COMMA = ",";
    private static final String NEW_LINE = "\n";
    File file;

    public FileReaderAndWriter(){
        String filePath = "contacts/contacts.csv";
        file = new File(filePath);
    }

    public void writeFile(ArrayList<Contact> arrayList) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        for (int i = 0; i < arrayList.size();i++){
            fileWriter.append(arrayList.get(i).getPhoneNumber());
            fileWriter.append(COMMA);
            fileWriter.append(arrayList.get(i).getGroup());
            fileWriter.append(COMMA);
            fileWriter.append(arrayList.get(i).getName());
            fileWriter.append(COMMA);
            fileWriter.append(arrayList.get(i).getGender());
            fileWriter.append(COMMA);
            fileWriter.append(arrayList.get(i).getAddress());
            fileWriter.append(COMMA);
            fileWriter.append(arrayList.get(i).getDateOfBirth());
            fileWriter.append(COMMA);
            fileWriter.append(arrayList.get(i).getEmail());
            fileWriter.append(NEW_LINE);
        }
        fileWriter.flush();
        fileWriter.close();
        System.out.println("Write to file complete!");

    }

    public ArrayList<Contact> readFile(ArrayList<Contact> students){
        for (int i = 0; i < students.size(); i++) {
            students.remove(i);
        }
        try {
            FileReader fileReader = new FileReader(file);
            String line;
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line= bufferedReader.readLine())!=null){
                String[] splitData = line.split(COMMA);
                String phoneNumber = splitData[0];
                String group = splitData[1];
                String name = splitData[2];
                String gender = splitData[3];
                String address = splitData[4];
                String dateOfBirth = splitData[5];
                String email = splitData[6];

                students.add(new Contact(phoneNumber, group, name, gender, address, dateOfBirth, email));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}
