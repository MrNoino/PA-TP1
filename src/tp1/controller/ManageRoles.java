package tp1.controller;

import java.util.ArrayList;
import tp1.model.Role;

/**
 * A class to manage roles on the database
 */
public class ManageRoles {

    private ArrayList<Role> roles;

    public ManageRoles() {
        roles = new ArrayList<Role>();
    }

    /**
     *
     * @return Returns a list of roles
     */
    public ArrayList<Role> getRoles() {
        return this.roles;
    }

    /**
     * Adds a role
     *
     * @param role The role to add to the list
     * @return Confirms if a role was added successfully
     */
    public boolean addRole(Role role) {
        return true;
    }

    /**
     * Updates a role
     *
     * @param role The role to be updated
     * @return Confirms if a role was updated successfully
     */
    public boolean updateRole(Role role) {
        return true;
    }

    /**
     * Deletes a role
     *
     * @param role The role to be deleted
     * @return Confirms if a role was deleted successfully
     */
    public boolean deleteRole(Role role) {
        return true;
    }
}
