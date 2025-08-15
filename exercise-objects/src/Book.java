public class Book {
    private String title;
    private String author;
    private boolean isAvailable;

//    public Book(String title, String author, boolean isAvailable) {
//
//    }

    public Book(String title, String author, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public void borrowBook() {
        this.isAvailable = false;
    }
}
