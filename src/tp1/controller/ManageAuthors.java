package tp1.controller;

import java.util.ArrayList;
import tp1.model.Author;
import tp1.model.DbWrapper;
import java.sql.*;

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
    
    public Author getAuthor(long id){
        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();
        ResultSet resultSet = dbWrapper.query("CALL get_author_by_id(?);", new Object[]{id});
        try {
            if(resultSet == null || !resultSet.next())
                return null;
            
            return new Author(resultSet.getLong("id"), 
                    resultSet.getString("name"), 
                    resultSet.getString("username"), 
                    resultSet.getString("email"), 
                    resultSet.getBoolean("active"), 
                    resultSet.getBoolean("deleted"), 
                    resultSet.getInt("role_id"),
                    resultSet.getString("nif"),
                    resultSet.getString("phone"),
                    resultSet.getString("address"),
                    resultSet.getString("activity_begin_date"),
                    resultSet.getInt("literary_style_id"));
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
     * Updates an author in the database
     *
     * @param author The author to be updated
     * @return Confirms if an author was updated successfully
     */
    public boolean updateAuthor(Author author) {
        DbWrapper dbWrapper = new DbWrapper();
        return dbWrapper.manipulate("CALL update_author(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[]{author.getId(),
            author.getName(),
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
     * Deletes an author
     *
     * @param author The author to be deleted
     * @return Confirms if an author was deleted successfully
     */
    public boolean deleteAuthor(Author author) {
        return true;
    }
}
