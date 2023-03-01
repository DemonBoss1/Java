abstract class Human {
    private String name, surname; // поля: имя, фамилия;

    public String getName() {
        // метод для получения имени;
        return name;
    }

    public String getSurname() {
        // метод для получения фамилии;
        return surname;
    }

    public Human(String name, String surname) {
        // конструктор для установки значений.
        this.name = name;
        this.surname = surname;
    }

    public abstract void printInfo();
    // абстрактный метод для вывода всей информации;
}

class Client extends Human {
    String bankName;

    @Override
    public void printInfo() {
        System.out.println(getName() + " " + getSurname() + ". " +
                "Bank: " + bankName);
    }

    public Client(String name, String surname, String bankName) {
        super(name, surname);
        this.bankName = bankName;
    }
}

class BankWorker extends Human {
    String bankName;

    @Override
    public void printInfo() {
        System.out.println(getName() + " " + getSurname() + ".  He works at:" +
                " " + bankName);
    }

    public BankWorker(String name, String surname, String bankName) {
        super(name, surname);
        this.bankName = bankName;
    }
}

public class Ex1 {
    public static void main(String[] args) {
        Client client = new Client("Erlich", "Bachman",
                "Sber");
        client.printInfo();
        BankWorker worker = new BankWorker("Richard", "Hendrix",
                "Bank of America");
        worker.printInfo();
    }
}