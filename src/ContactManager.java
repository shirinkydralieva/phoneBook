import java.io.*;
import java.util.Scanner;

public class ContactManager {
    private Contact[] contacts;
    private int size;

    public ContactManager() {
        this.contacts = new Contact[100];
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void addContact(Contact contact) {
        contacts[size] = contact;
        size++;
    }

    public void readContact(int contactNumber) {
        System.out.println(contacts[contactNumber - 1]);
    }

    public void printContactList() {
        //Вспомогательный метод
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + contacts[i].getFirstName() + " " + contacts[i].getLastName());
        }
    }

    public void updateContact(int contactNumber) {
        String updatedField;
        System.out.println("Выберите поле, которое хотите изменить: 1. Имя " +
                "\n2. Фамилия " +
                "\n3. Номер телефона " +
                "\n4. Эл.почта" +
                "\n5. Изменить все поля"
        );
        String choice = new Scanner(System.in).nextLine();
        switch (choice) {
            case "1":
                System.out.println("Введите изменения:");
                updatedField = new Scanner(System.in).nextLine();
                contacts[contactNumber - 1].setFirstName(updatedField);
                break;
            case "2":
                System.out.println("Введите изменения:");
                updatedField = new Scanner(System.in).nextLine();
                contacts[contactNumber - 1].setLastName(updatedField);
                break;
            case "3":
                System.out.println("Введите изменения:");
                updatedField = new Scanner(System.in).nextLine();
                contacts[contactNumber - 1].setPhoneNumber(updatedField);
                break;
            case "4":
                System.out.println("Введите изменения:");
                updatedField = new Scanner(System.in).nextLine();
                contacts[contactNumber - 1].setEmail(updatedField);
                break;
            case "5":
                System.out.println("Имя:");
                updatedField = new Scanner(System.in).nextLine();
                contacts[contactNumber - 1].setFirstName(updatedField);
                System.out.println("Фамилия:");
                updatedField = new Scanner(System.in).nextLine();
                contacts[contactNumber - 1].setLastName(updatedField);
                System.out.println("Номер телефона:");
                updatedField = new Scanner(System.in).nextLine();
                contacts[contactNumber - 1].setPhoneNumber(updatedField);
                System.out.println("Эл.почта:");
                updatedField = new Scanner(System.in).nextLine();
                contacts[contactNumber - 1].setEmail(updatedField);
                break;
            default:
                System.out.println("Неправильно введены данные.");
                break;
        }
        System.out.println("Готово! Теперь проверьте изменения.");
    }

    public void deleteContact (int contactNumber)  {
        for (int i = contactNumber - 1; i < size - 1 ; i++) {
            contacts[i] = null;
            contacts[i] = contacts[i + 1];
        }
        size--;
        System.out.println("Контакт успешно удален!");
    }

    public void saveContactsToFile() throws IOException {
        FileWriter fileWriter = new FileWriter("contacts.txt");
        for (int i = 0; i < size; i++) {
            fileWriter.write(contacts[i].getFirstName() + "\n" + contacts[i].getLastName() + "\n" + contacts[i].getPhoneNumber() + "\n" + contacts[i].getEmail() + "\n");
        }
        fileWriter.close();
    }

    public void loadContactsFromFile () throws IOException {
        FileReader fileReader = new FileReader("contacts.txt");
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine()){
            Contact contact = new Contact();
            if (scanner.hasNextLine()) {
                contact.setFirstName(scanner.nextLine());
            }
            if (scanner.hasNextLine()) {
                contact.setLastName(scanner.nextLine());
            }
            if (scanner.hasNextLine()) {
                contact.setPhoneNumber(scanner.nextLine());
            }
            if (scanner.hasNextLine()) {
                contact.setEmail(scanner.nextLine());
            }

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            contacts[size] = contact;
            size++;
        }
        fileReader.close();
        scanner.close();
    }

    public void searchContactsByName(String contactName){
        for (int i = 0; i < size; i++) {
            if (contacts[i].getFirstName().equalsIgnoreCase(contactName)){
                System.out.println("Контакт найден! Вот он: \n" + contacts[i]);
            }
        }
    }

    public void searchContactsByPhoneNumber(String contactPhone){
        for (int i = 0; i < size; i++) {
            if (contacts[i].getPhoneNumber().equalsIgnoreCase(contactPhone)){
                System.out.println("Контакт найден! Вот он: " + contacts[i]);
            }
        }
    }
}
