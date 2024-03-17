package tp1.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import tp1.model.DbWrapper;
import tp1.model.Manager;

public class ManageManagers {

    private ArrayList<Manager> managers;

    /**
     * Class construtor initializing the ArrayList
     */
    public ManageManagers() {
        managers = new ArrayList<Manager>();
    }
    
    /**
     * Connects to the database and retrieve the number of managers
     * @return the number of managers in the database
     */
    public int getTotalManagers(){
        
        DbWrapper dbWrapper = new DbWrapper();
                    
        ResultSet resultSet = dbWrapper.query("SELECT * FROM total_managers;");
        
        try {
            if(resultSet == null || !resultSet.next())
                return -1;

            return resultSet.getInt("total_managers");
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally{
            dbWrapper.closeConnection();
        }
    }

    /**
     *
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
