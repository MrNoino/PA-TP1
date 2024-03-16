package tp1.controller;

import java.util.ArrayList;
import tp1.model.Author;

/**
 *
 * @author lighttigerXIV
 */
public class ManageAuthors {

    private ArrayList<Author> authors;

    public ManageAuthors() {
        authors = new ArrayList<Author>();
    }

    public ArrayList<Author> getAuthors() {
        return this.authors;
    }

    public boolean addAuthor(Author author) {
        return true;
    }

    public boolean updateAuthor(Author author) {
        return true;
    }

    public boolean deleteAuthor(Author author) {
        return true;
    }
}
