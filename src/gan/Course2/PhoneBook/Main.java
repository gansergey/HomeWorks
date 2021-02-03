package gan.homeworks.Collection.PhoneBook;

public class Main {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "+7-999-333-22-48");
        phoneBook.add("Петров", "+7-921-145-45-54");
        phoneBook.add("Плотников", "+7-918-444-22-44");
        phoneBook.add("Третьякова", "+7-999-555-55-55");
        phoneBook.add("Плотников", "+7-911-987-42-33");

        System.out.println(phoneBook.get("Иван"));
        System.out.println(phoneBook.toString());
    }
}

