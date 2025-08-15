//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Car carOne = new Car("Geo", "Prism", 1992);
        Car carTwo = new Car("Honda", "Fit", 2015);

        System.out.println(carOne.displayInfo());
        System.out.println(carTwo.displayInfo());

        Book bookOne = new Book("1984", "George Orwell", true);

        bookOne.borrowBook();
        System.out.println(bookOne);
    }
}