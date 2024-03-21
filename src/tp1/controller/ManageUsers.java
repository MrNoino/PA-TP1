package tp1.controller;

import java.util.ArrayList;
import tp1.model.DbWrapper;
import tp1.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;       
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManageUsers {

    private ArrayList<User> users;

    public ManageUsers() {

        users = new ArrayList<User>();

    }

    /**
     * Checks if the login credentials are correct
     * @return The id of the user
     */
    public User login(String username, String password) {

        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();
        ResultSet resultSet = dbWrapper.query("CALL login(?, ?);", new Object[]{username, password});
        
        try {
            if(resultSet == null || !resultSet.next()){
                System.out.println("Credênciais inválidas");
                return null;
            }
            return new User(resultSet.getLong("id"), 
                            resultSet.getString("name"), 
                            resultSet.getString("username"), 
                            resultSet.getString("email"),
                            resultSet.getBoolean("active"),
                            resultSet.getBoolean("deleted"),
                            resultSet.getInt("role_id"));
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally{
            dbWrapper.disconnect();
        }
    }
    
    public boolean existsUsername(String username){
        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();
        ResultSet resultSet = dbWrapper.query("CALL exists_username(?);", new Object[]{username});
        try {
            if(resultSet == null || !resultSet.next())
                return false;

            if(resultSet.getBoolean("exists")){
                System.out.println("\nNome de utilizador já em uso.\n");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            dbWrapper.disconnect();
        }
        return false;
    }
    
    public boolean existsEmail(String email){
        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();
        ResultSet resultSet = dbWrapper.query("CALL exists_email(?);", new Object[]{email});
        try {
            if(resultSet == null || !resultSet.next())
                return false;

            if(resultSet.getBoolean("exists")){
                System.out.println("\nEmail já em uso.\n");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            dbWrapper.disconnect();
        }
        return false;
    }
    
    public boolean existsNIF(String nif){
        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();
        ResultSet resultSet = dbWrapper.query("CALL exists_nif(?);", new Object[]{nif});
        try {
            if(resultSet == null || !resultSet.next())
                return false;

            if(resultSet.getBoolean("exists")){
                System.out.println("\nNIF já em uso.\n");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            dbWrapper.disconnect();
        }
        return false;
    }
    
    /**
     * Search an user from database by id
     * @param id id of the user
     * @return the user searched
     */
    public User getUser(long id) {
        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();
        ResultSet resultSet = dbWrapper.query("CALL get_user_by_id(?);", new Object[]{id});
        try {
            if(resultSet == null || !resultSet.next())
                return null;
            
            return new User(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getString("username"), resultSet.getString("email"), resultSet.getBoolean("active"), resultSet.getBoolean("deleted"), resultSet.getInt("role_id"));
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean changeUserStatus(long id, boolean active){
        DbWrapper dbWrapper = new DbWrapper();
        return dbWrapper.manipulate("CALL change_user_status(?, ?);", new Object[]{id, active}) > 0;
    }

    /**
     * Adds a user
     *
     * @param user The user to add to the list
     * @return Confirms if a user was added successfully
     */
    public boolean addUser(User user) {
        return true;
    }

    /**
     * Updates a user
     *
     * @param user The user to be updated
     * @return Confirms if a user was updated successfully
     */
    public boolean updateUser(User user) {
        return true;
    }

    /**
     * Deletes a user
     *
     * @param user The user to be deleted
     * @return Confirms if a user was deleted successfully
     */
    public boolean deleteUser(User user) {
        return true;
    }
}
