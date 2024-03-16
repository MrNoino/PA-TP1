package tp1.controller;

import java.util.ArrayList;
import tp1.model.Role;

/**
 *
 * @author lighttigerXIV
 */
public class ManageRoles {

    private ArrayList<Role> roles;

    public ManageRoles() {
        roles = new ArrayList<Role>();
    }

    public ArrayList<Role> getRoles() {
        return this.roles;
    }

    public boolean addRole(Role role) {
        return true;
    }

    public boolean updateRole(Role role) {
        return true;
    }

    public boolean deleteRole(Role role) {
        return true;
    }
}
