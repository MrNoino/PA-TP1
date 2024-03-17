package tp1.controller;

import java.util.ArrayList;
import tp1.model.DbWrapper;
import tp1.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
        

public class ManageUsers {

    private ArrayList<User> users;

    public ManageUsers() {

        users = new ArrayList<User>();

    }

    /**
     * Checks if the login credentials are correct
     * @return The id of the user
     */
    public long login(String username, String password) {

        DbWrapper dbWrapper = new DbWrapper();
        ResultSet resultSet = dbWrapper.query("CALL login(?, ?);", new Object[]{username, password});
        
        try {
            if(resultSet == null || !resultSet.next()){
                System.out.println("Credenciais inválidas");
                return -1;
            }
            return resultSet.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally{
            dbWrapper.closeConnection();
        }
    }

    /**
     *
     * @return Returns a list of users
     */
    public ArrayList<User> getUsers() {
        return this.users;
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
