package tp1.controller;

import java.util.ArrayList;
import tp1.model.Log;

/**
 *
 * @author lighttigerXIV
 */
public class ManageLogs {

    private ArrayList<Log> logs;

    public ManageLogs() {
        logs = new ArrayList<Log>();
    }

    public ArrayList<Log> getLogs() {
        return this.logs;
    }

    public boolean addLog(Log log) {
        return true;
    }

    public boolean updateLog(Log log) {
        return true;
    }

    public boolean deleteLog(Log log) {
        return true;
    }
}
