package tp1.controller;

import java.util.ArrayList;
import tp1.model.Log;
import tp1.model.DbWrapper;
import java.sql.*;
import tp1.model.User;

/**
 * A class to manage logs on the database
 */
public class ManageLogs {

    private ArrayList<Log> logs;

    public ManageLogs() {
        logs = new ArrayList<Log>();
    }

    /**
     *
     * @return Returns a list of logs
     */
    public ArrayList<Log> getLogs(int page) {

        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();
        ResultSet resultSet = dbWrapper.query("CALL get_logs_paginated(?)", new Object[]{page});

        try {
            if (resultSet == null) {
                return null;
            }

            while (resultSet.next()) {
                this.logs.add(new Log(resultSet.getInt("user_id"),
                        resultSet.getString("datetime"),
                        resultSet.getString("action")));
            }
            return this.logs;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this.logs;
    }

    /**
     *
     * @return Returns a list of logs
     */
    public ArrayList<Log> getLogsByUser(int userId, int page) {

        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();
        ResultSet resultSet = dbWrapper.query("CALL get_logs_by_user_paginated(?,?)", new Object[]{userId, page});

        try {
            if (resultSet == null) {
                return null;
            }

            while (resultSet.next()) {
                this.logs.add(new Log(resultSet.getInt("user_id"),
                        resultSet.getString("datetime"),
                        resultSet.getString("action")));
            }
            return this.logs;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this.logs;
    }

    /**
     * Adds a log
     *
     * @param log The log to add to the list
     * @return Confirms if a log was added successfully
     */
    public boolean addLog(Log log) {

        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();

        return dbWrapper.manipulate("CALL insert_log(?,?);", new Object[]{log.getUserId(), log.getAction()}) > 0;
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
