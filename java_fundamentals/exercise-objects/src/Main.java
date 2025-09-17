//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // instantiate Cars, print out info
        Car carOne = new Car("Geo", "Prism", 1992);
        Car carTwo = new Car("Honda", "Fit", 2015);
        System.out.println(carOne.displayInfo());
        System.out.println(carTwo.displayInfo());

        // print out Book info and call functions
        Book book1 = new Book("1984", "George Orwell", true);
        book1.displayStatus();
        System.out.println("Borrowing the book...");
        book1.borrowBook();
        System.out.println(book1.displayStatus());

        // print out Bank info and call functions
        BankAccount acc1 = new BankAccount("Alice", 1000.0);
//        BankAccount acc2 = acc1; // Reference copy
        System.out.println(acc1.getBalance());
        System.out.println("Depositing $500 to acc2...");
        acc1.deposit(500);
        System.out.println(acc1.getBalance());
    }
}