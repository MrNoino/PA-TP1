package tp1.controller;

import java.util.ArrayList;
import tp1.model.Log;

public class ManageLogs {

    private ArrayList<Log> logs;

    public ManageLogs() {
        logs = new ArrayList<Log>();
    }

    /**
     *
     * @return Returns a list of logs
     */
    public ArrayList<Log> getLogs() {
        return this.logs;
    }

    /**
     * Adds a log
     *
     * @param log The log to add to the list
     * @return Confirms if a log was added successfully
     */
    public boolean addLog(Log log) {
        return true;
    }

    /**
     * Updates a log
     *
     * @param log The log to be updated
     * @return Confirms if a log was updated successfully
     */
    public boolean updateLog(Log log) {
        return true;
    }

    /**
     * Deletes a log
     *
     * @param log The log to be deleted
     * @return Confirms if a log was deleted successfully
     */
    public boolean deleteLog(Log log) {
        return true;
    }
}
