package tp1.controller;

import java.util.ArrayList;
import tp1.model.Book;

/**
 *
 * @author lighttigerXIV
 */
public class ManageBooks {

    private ArrayList<Book> books;

    public ManageBooks() {
        books = new ArrayList<Book>();
    }

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    public boolean addBook(Book book) {
        return true;
    }

    public boolean updateBook(Book book) {
        return true;
    }

    public boolean deleteBook(Book book) {
        return true;
    }
}
