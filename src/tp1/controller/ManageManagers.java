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

    public ArrayList<Manager> getManagers() {
        return this.managers;
    }

    public boolean addManager(Manager manager) {
        return true;
    }

    public boolean updateManager(Manager manager) {
        return true;
    }

    public boolean deleteManager(Manager manager) {
        return true;
    }
}
