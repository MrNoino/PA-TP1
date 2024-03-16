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

    /**
     *
     * @return Returns a list of authors
     */
    public ArrayList<Author> getAuthors() {
        return this.authors;
    }

    /**
     * Adds an author
     *
     * @param author The author to add to the list
     * @return Confirms if an author was added successfully
     */
    public boolean addAuthor(Author author) {
        return true;
    }

    /**
     * Updates an author
     *
     * @param author The author to be updated
     * @return Confirms if an author was updated successfully
     */
    public boolean updateAuthor(Author author) {
        return true;
    }

     /**
     * Deletes an author
     *
     * @param author The author to be deleted
     * @return Confirms if an author was deleted successfully
     */
    public boolean deleteAuthor(Author author) {
        return true;
    }
}
