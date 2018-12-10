package librarymanagement;

public class Book {

    private int bookId;
    private String title;
private String author;

    public Book(int id, String title, String author) {
        bookId = id;
        this.title = title;
        this.author=author;
    }

    public int getId() {
        return bookId;
    }

    public void setId(int id) {
        bookId = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author=author;
    }
}
