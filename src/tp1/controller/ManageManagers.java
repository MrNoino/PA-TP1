package tp1.controller;

import java.util.ArrayList;
import tp1.model.Manager;

/**
 *
 * @author lighttigerXIV
 */
public class ManageManagers {

    private ArrayList<Manager> managers;

    public ManageManagers() {
        managers = new ArrayList<Manager>();
    }

    /**
     *
     * @return Returns a list of managers
     */
    public ArrayList<Manager> getManagers() {
        return this.managers;
    }

    /**
     * Adds a manager
     *
     * @param manager The manager to add to the list
     * @return Confirms if a manager was added successfully
     */
    public boolean addManager(Manager manager) {
        return true;
    }

    /**
     * Updates a manager
     *
     * @param manager The manager to be updated
     * @return Confirms if a manager was updated successfully
     */
    public boolean updateManager(Manager manager) {
        return true;
    }

    /**
     * Deletes a manager
     *
     * @param manager The manager to be deleted
     * @return Confirms if a manager was deleted successfully
     */
    public boolean deleteManager(Manager manager) {
        return true;
    }
}
