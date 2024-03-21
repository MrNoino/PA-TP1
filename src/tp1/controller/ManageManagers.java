package tp1.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import tp1.model.Author;
import tp1.model.DbWrapper;
import tp1.model.Manager;

/**
 * A class to manage managers on the database
 */
public class ManageManagers {

    private ArrayList<Manager> managers;

    /**
     * Class constructor initializing the ArrayList
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
        dbWrapper.connect();
        ResultSet resultSet = dbWrapper.query("SELECT * FROM total_managers;");
        
        try {
            if(resultSet == null || !resultSet.next())
                return -1;

            return resultSet.getInt("total_managers");
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally{
            dbWrapper.disconnect();
        }
    }
    
    public Manager getManager(long id) {
        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();
        ResultSet resultSet = dbWrapper.query("CALL get_manager_by_id(?);", new Object[]{id});
        try {
            if(resultSet == null || !resultSet.next())
                return null;
            
            return new Manager(resultSet.getLong("id"), 
                    resultSet.getString("name"), 
                    resultSet.getString("username"), 
                    resultSet.getString("email"), 
                    resultSet.getBoolean("active"), 
                    resultSet.getBoolean("deleted"), 
                    resultSet.getInt("role_id"));
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
     * Inserts a manager in the database
     *
     * @param manager The manager to insert
     * @return Confirms if a manager was inserted successfully
     */
    public boolean insertManager(Manager manager) {
        DbWrapper dbWrapper = new DbWrapper();
        return dbWrapper.manipulate("CALL insert_manager(?, ?, ?, ?, ?);", new Object[]{manager.getName(),
                                                                                                manager.getUsername(),
                                                                                                manager.getPassword(),
                                                                                                manager.getEmail(),
                                                                                                manager.getRoleId()}) > 0;
    }

    /**
     * Updates a manager
     *
     * @param manager The manager to be updated
     * @return Confirms if a manager was updated successfully
     */
    public boolean updateManager(Manager manager) {
        DbWrapper dbWrapper = new DbWrapper();
        return dbWrapper.manipulate("CALL update_user(?, ?, ?, ?, ?, ?);", new Object[]{manager.getId(),
            manager.getName(),
            manager.getUsername(),
            manager.getPassword(),
            manager.getEmail(),
            manager.getRoleId()}) > 0;
    }
    
}
