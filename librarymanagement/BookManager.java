package librarymanagement;

import java.util.*;
import java.util.Comparator;

public class BookManager {

    private HashMap<Integer, Book> books;

    public BookManager() {
        books = new HashMap<Integer, Book>();

    }

    public boolean addBook(int id, String title, String author) {
        if (books.containsKey(id)) {
            return false;
        }
        Book book = new Book(id, title, author);
        books.put(id, book);
        return true;
    }

    public boolean addBook(Book book) {
        if (books.containsKey(book.getId())) {
            return false;
        }

        books.put(book.getId(), book);
        return true;
    }

    public boolean remove(Book b) {
        return remove(b.getId());
    }

    public boolean remove(int id) {
        if (!books.containsKey(id)) {
            return false;
        }
        books.remove(id);
        return true;
    }

    public Book find(int id) {
        return books.get(id);
    }

    public ArrayList<Book> getBookList() {
        return new ArrayList<Book>(books.values());

    }
}

class IdCompare implements Comparator<Book> {
    // Used for sorting in ascending order of id

    @Override
    public int compare(Book a, Book b) {
        return a.getId() - b.getId();
    }
}

class NameCompare implements Comparator<Book> {
    // Used for sorting in ascending order of names 

    @Override
    public int compare(Book a, Book b) {
        return a.getTitle().compareTo(b.getTitle());
    }
}

class AuthorCompare implements Comparator<Book> {
    // Used for sorting in ascending order of author names

    @Override
    public int compare(Book a, Book b) {
        return a.getAuthor().compareTo(b.getAuthor());
    }
}
