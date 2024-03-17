package tp1.controller;

import java.util.ArrayList;
import tp1.model.RoleNotification;

/**
 * A class to manage role notifications on the database
 */
public class ManageRoleNotifications {

    private ArrayList<RoleNotification> roleNotifications;

    public ManageRoleNotifications() {
        roleNotifications = new ArrayList<RoleNotification>();
    }

    /**
     *
     * @return Returns a list of role notifications
     */
    public ArrayList<RoleNotification> getRoleNotifications() {
        return this.roleNotifications;
    }

    /**
     * Adds a role notification
     *
     * @param roleNotification The role notification to add to the list
     * @return Confirms if a role notification was added successfully
     */
    public boolean addRoleNotification(RoleNotification roleNotification) {
        return true;
    }

    /**
     * Updates a role notification
     *
     * @param roleNotification The role notification to be updated
     * @return Confirms if a role notification was updated successfully
     */
    public boolean updateRoleNotification(RoleNotification roleNotification) {
        return true;
    }

    /**
     * Deletes a role notification
     *
     * @param roleNotification The role notification to be deleted
     * @return Confirms if a role notification was deleted successfully
     */
    public boolean deleteRoleNotification(RoleNotification roleNotification) {
        return true;
    }
}
