package tp1.controller;

import java.util.ArrayList;
import tp1.model.DbWrapper;
import tp1.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManageUsers {

    private ArrayList<User> users;

    public ManageUsers() {

        users = new ArrayList<User>();

    }

    /**
     * Checks if the login credentials are correct
     *
     * @return The id of the user
     */
    public User login(String username, String password) {

        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();
        ResultSet resultSet = dbWrapper.query("CALL login(?, ?);", new Object[]{username, password});

        try {
            if (resultSet == null || !resultSet.next()) {
                System.out.println("\nCredênciais inválidas\n");
                return null;
            }
            return new User(resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("username"),
                    resultSet.getString("email"),
                    resultSet.getBoolean("active"),
                    resultSet.getBoolean("deleted"),
                    resultSet.getInt("role_id"));

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            dbWrapper.disconnect();
        }
    }

    /**
     * Search in the database if the username exists
     * @param username username to be search
     * @return if the username exists
     */
    public boolean existsUsername(String username) {
        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();
        ResultSet resultSet = dbWrapper.query("CALL exists_username(?);", new Object[]{username});
        try {
            if (resultSet == null || !resultSet.next()) {
                return false;
            }

            if (resultSet.getBoolean("exists")) {
                System.out.println("\nNome de utilizador já em uso.\n");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbWrapper.disconnect();
        }
        return false;
    }

    /**
     * Search in the database if the email exists
     * @param email email to be search
     * @return if the email exists
     */
    public boolean existsEmail(String email) {
        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();
        ResultSet resultSet = dbWrapper.query("CALL exists_email(?);", new Object[]{email});
        try {
            if (resultSet == null || !resultSet.next()) {
                return false;
            }

            if (resultSet.getBoolean("exists")) {
                System.out.println("\nEmail já em uso.\n");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbWrapper.disconnect();
        }
        return false;
    }

    /**
     * Search in the database if the NIF exists
     * @param nif nif to be search
     * @return if the nif exists
     */
    public boolean existsNIF(String nif) {
        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();
        ResultSet resultSet = dbWrapper.query("CALL exists_nif(?);", new Object[]{nif});
        try {
            if (resultSet == null || !resultSet.next()) {
                return false;
            }

            if (resultSet.getBoolean("exists")) {
                System.out.println("\nNIF já em uso.\n");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbWrapper.disconnect();
        }
        return false;
    }

    /**
     * Search an user from database by id
     *
     * @param id id of the user
     * @return the user searched
     */
    public User getUser(long id) {
        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();
        ResultSet resultSet = dbWrapper.query("CALL get_user_by_id(?);", new Object[]{id});
        try {
            if (resultSet == null || !resultSet.next()) {
                return null;
            }

            return new User(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getString("username"), resultSet.getString("email"), resultSet.getBoolean("active"), resultSet.getBoolean("deleted"), resultSet.getInt("role_id"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Change the user status in the database
     * @param id id of the user to be chnaged
     * @param active status to be changed
     * @return if the status was changed
     */
    public boolean changeUserStatus(long id, boolean active) {
        DbWrapper dbWrapper = new DbWrapper();
        return dbWrapper.manipulate("CALL change_user_status(?, ?);", new Object[]{id, active}) > 0;
    }

    /**
     * Get users from database by defining sorting order of the name and page
     * @param sortOrder sorting order of the name
     * @param page page to be retrieve
     * @return a list of users
     */
    public ArrayList<User> getUsers(String sortOrder, int page) {
        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();
        ResultSet resultSet = dbWrapper.query("CALL get_users_paginated(?, ?);", new Object[]{sortOrder, page});
        try {
            if (resultSet == null) {
                return null;
            }

            while (resultSet.next()) {
                this.users.add(new User(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getBoolean("active"),
                        resultSet.getBoolean("deleted"),
                        resultSet.getInt("role_id")));
            }
            return this.users;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    
    /**
     * Get users by name from database 
     * @param name name to be searched
     * @return a list of users
     */
    public ArrayList<User> getUsersByName(String name) {
        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();
        ResultSet resultSet = dbWrapper.query("CALL get_users_by_name(?);", new Object[]{name});
        try {
            if (resultSet == null) {
                return null;
            }

            while (resultSet.next()) {
                this.users.add(new User(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getBoolean("active"),
                        resultSet.getBoolean("deleted"),
                        resultSet.getInt("role_id")));
            }
            return this.users;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Get users by username from database 
     * @param username username to be searched
     * @return a list of users
     */
    public ArrayList<User> getUsersByUsername(String username) {
        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();
        ResultSet resultSet = dbWrapper.query("CALL get_users_by_username(?);", new Object[]{username});
        try {
            if (resultSet == null) {
                return null;
            }

            while (resultSet.next()) {
                this.users.add(new User(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getBoolean("active"),
                        resultSet.getBoolean("deleted"),
                        resultSet.getInt("role_id")));
            }
            return this.users;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Get users by role from database 
     * @param role role to be searched
     * @return a list of users
     */
    public ArrayList<User> getUsersByRole(String role) {
        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();
        ResultSet resultSet = dbWrapper.query("CALL get_users_by_role(?);", new Object[]{role});
        try {
            if (resultSet == null) {
                return null;
            }

            while (resultSet.next()) {
                this.users.add(new User(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getBoolean("active"),
                        resultSet.getBoolean("deleted"),
                        resultSet.getInt("role_id")));
            }
            return this.users;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
