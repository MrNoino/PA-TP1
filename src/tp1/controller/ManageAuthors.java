package tp1.controller;

import java.util.ArrayList;
import tp1.model.Author;
import tp1.model.DbWrapper;

/**
 * A class to manage authors on the database
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
     * Inserts an author in the database
     *
     * @param author The author to insert
     * @return Confirms if an author was inserted successfully
     */
    public boolean insertAuthor(Author author) {
        DbWrapper dbWrapper = new DbWrapper();
        return dbWrapper.manipulate("CALL insert_author(?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[]{author.getName(),
                                                                                                        author.getUsername(),
                                                                                                        author.getPassword(),
                                                                                                        author.getEmail(),
                                                                                                        author.getRoleId(),
                                                                                                        author.getNif(),
                                                                                                        author.getPhone(),
                                                                                                        author.getAddress(),
                                                                                                        author.getLiteraryStyleId()}) > 0;
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
