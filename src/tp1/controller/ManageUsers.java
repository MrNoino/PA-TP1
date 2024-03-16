package tp1.controller;

import java.util.ArrayList;
import tp1.model.User;

/**
 *
 * @author Nuno
 */
public class ManageUsers {

    private ArrayList<User> users;

    public ManageUsers() {

        users = new ArrayList<User>();

    }

    /**
     * Checks if the login credentials are correct
     * @return Confirms if the login was successful
     */
    public int Login() {

        return 0;

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
