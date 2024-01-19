import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        ContactManager contactManager = new ContactManager();
        String firstName, lastName, phoneNumber, email;
        String choice;
        int contactNumber;
        printMenu();
        choice = scanner.nextLine();
        while (!Objects.equals(choice, "0")){
            switch (choice){
                case "1":
                    if (contactManager.getSize() == 0){
                        System.out.println("Телефонная книга пуста!");
                        break;
                    } else {
                        System.out.println("Выберите контакт:");
                        contactManager.printContactList();
                    }
                    try {
                        contactNumber = scanner.nextInt();
                        if (contactNumber > contactManager.getSize() || contactNumber <= 0){
                            System.out.println("Недопустимое число!");
                        } else {
                            contactManager.readContact(contactNumber);
                        }
                    } catch (InputMismatchException e){
                        System.err.println("Недопустимый символ!");
                        break;
                    }
                    break;
                case "2":
                    System.out.println("Введите имя:");
                    firstName = scanner.nextLine();
                    System.out.println("Введите фамилию:");
                    lastName = scanner.nextLine();
                    System.out.println("Введите номер телефона:");
                    phoneNumber = scanner.nextLine();
                    System.out.println("Введите электронную почту:");
                    email = scanner.nextLine();
                    contactManager.addContact(new Contact(firstName,lastName,phoneNumber,email));
                    System.out.println("Контакт успешно создан!");
                    break;
                case "3":
                    if (contactManager.getSize() == 0){
                        System.out.println("Телефонная книга пуста!");
                        break;
                    } else {
                        System.out.println("Выберите контакт:");
                        contactManager.printContactList();
                    }
                    try {
                        contactNumber = scanner.nextInt();
                        if (contactNumber > contactManager.getSize() || contactNumber <= 0){
                            System.out.println("Недопустимое число!");
                        } else{
                            contactManager.updateContact(contactNumber);
                        }
                    } catch (InputMismatchException e){
                        System.err.println("Недопустимый символ!");
                        break;
                    }
                    break;
                case "4":
                    if (contactManager.getSize() == 0){
                        System.out.println("Телефонная книга пуста!");
                        break;
                    } else {
                        System.out.println("Выберите контакт:");
                        contactManager.printContactList();
                    }
                    try {
                        contactNumber = scanner.nextInt();
                        if (contactNumber > contactManager.getSize() || contactNumber <= 0){
                            System.out.println("Недопустимое число!");
                        } else {
                            contactManager.deleteContact(contactNumber);
                        }
                    } catch (InputMismatchException e){
                        System.err.println("Недопустимый символ!");
                        break;
                    }
                    break;
                case "5":
                    if (contactManager.getSize() == 0){
                        System.out.println("Телефонная книга пуста!");
                        break;
                    } else {
                        contactManager.saveContactsToFile();
                        System.out.println("Контакты успешно сохранены в файл!");
                    }
                    break;
                case "6":
                    contactManager.loadContactsFromFile();
                    System.out.println("Файл с контактами успешно загружен!");
                    break;
                case "7":
                    if (contactManager.getSize() == 0){
                        System.out.println("Телефонная книга пуста!");
                        break;
                    } else {
                        System.out.println("Введите имя контакта, который ищете:");
                        firstName = scanner.nextLine();
                        contactManager.searchContactsByName(firstName);
                    }
                    break;
                case "8":
                    if (contactManager.getSize() == 0){
                        System.out.println("Телефонная книга пуста!");
                        break;
                    } else {
                    System.out.println("Введите номер контакта, который ищете:");
                    phoneNumber = scanner.nextLine();
                    contactManager.searchContactsByPhoneNumber(phoneNumber);
                    }
                    break;
            }
            printMenu();
            choice = scanner.nextLine();
        }

    }

    public static void printMenu(){
        System.out.println("========== Телефонная книга =========="
                + "\n1. Просмотреть контакты"
                + "\n2. Создать новый контакт"
                + "\n3. Обновить контакт"
                + "\n4. Удалить контакт"
                + "\n5. Сохранить контакты в файл"
                + "\n6. Загрузить контакты из файла"
                + "\n7. Поиск контакта по имени"
                + "\n8. Поиск контакта по номеру телефона"
                + "\n0. Выход"
                + "\n Выберите действие:"
        );
    }
}