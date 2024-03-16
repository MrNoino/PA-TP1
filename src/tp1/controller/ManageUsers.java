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

    public int Login() {

        return 0;

    }

    public ArrayList<User> getUsers() {
        return this.users;
    }

    public boolean addUser(User user) {
        return true;
    }

    public boolean updateUser(User user) {
        return true;
    }

    public boolean deleteUser(User user) {
        return true;
    }
}
