package tp1.controller;

import java.util.ArrayList;
import tp1.model.RoleNotification;

/**
 *
 * @author lighttigerXIV
 */
public class ManageRoleNotifications {

    private ArrayList<RoleNotification> roleNotifications;

    public ManageRoleNotifications() {
        roleNotifications = new ArrayList<RoleNotification>();
    }

    public ArrayList<RoleNotification> getRoleNotifications() {
        return this.roleNotifications;
    }

    public boolean addRoleNotification(RoleNotification roleNotification) {
        return true;
    }

    public boolean updateRoleNotification(RoleNotification roleNotification) {
        return true;
    }

    public boolean deleteRoleNotification(RoleNotification roleNotification) {
        return true;
    }
}
