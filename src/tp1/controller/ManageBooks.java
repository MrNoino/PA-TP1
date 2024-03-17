package tp1.controller;

import java.util.ArrayList;
import tp1.model.Book;

/**
 * A class to manage books on the database
 */
public class ManageBooks {

    private ArrayList<Book> books;

    public ManageBooks() {
        books = new ArrayList<Book>();
    }

    /**
     *
     * @return Returns a list of books
     */
    public ArrayList<Book> getBooks() {
        return this.books;
    }

    /**
     * Adds a book
     *
     * @param book The book to add to the list
     * @return Confirms if a book was added successfully
     */
    public boolean addBook(Book book) {
        return true;
    }

    /**
     * Updates a book
     *
     * @param book The book to be updated
     * @return Confirms if a book was updated successfully
     */
    public boolean updateBook(Book book) {
        return true;
    }

    /**
     * Deletes a book
     *
     * @param book The book to be deleted
     * @return Confirms if a book was deleted successfully
     */
    public boolean deleteBook(Book book) {
        return true;
    }
}
