package tp1.controller;

import java.util.ArrayList;
import tp1.model.DbWrapper;
import tp1.model.Reviewer;
import java.sql.*;

/**
 * A class to manage reviewers on the database
 */
public class ManageReviewers {

    private ArrayList<Reviewer> reviewers;

    public ManageReviewers() {
        reviewers = new ArrayList<Reviewer>();
    }

    /**
     *
     * @return Returns a list of reviewers
     */
    public ArrayList<Reviewer> getReviewers() {
        return this.reviewers;
    }
    
    public Reviewer getReviewer(long id){
        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();
        ResultSet resultSet = dbWrapper.query("CALL get_reviewer_by_id(?);", new Object[]{id});
        try {
            if(resultSet == null || !resultSet.next())
                return null;
            
            return new Reviewer(resultSet.getLong("id"), 
                    resultSet.getString("name"), 
                    resultSet.getString("username"), 
                    resultSet.getString("email"), 
                    resultSet.getBoolean("active"), 
                    resultSet.getBoolean("deleted"), 
                    resultSet.getInt("role_id"),
                    resultSet.getString("nif"),
                    resultSet.getString("phone"),
                    resultSet.getString("address"),
                    resultSet.getString("graduation"),
                    resultSet.getString("specialization"));
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Insert a reviewer in the databsae
     *
     * @param reviewer The reviewer to insert
     * @return Confirms if a reviewer was inserted successfully
     */
    public boolean insertReviewer(Reviewer reviewer) {
        DbWrapper dbWrapper = new DbWrapper();
        return dbWrapper.manipulate("CALL insert_reviewer(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[]{reviewer.getName(),
                                                                                                        reviewer.getUsername(),
                                                                                                        reviewer.getPassword(),
                                                                                                        reviewer.getEmail(),
                                                                                                        reviewer.getRoleId(),
                                                                                                        reviewer.getNif(),
                                                                                                        reviewer.getPhone(),
                                                                                                        reviewer.getAddress(),
                                                                                                        reviewer.getGraduation(),
                                                                                                        reviewer.getSpecialization()}) > 0;
    }

    /**
     * Updates a reviewer in the database
     *
     * @param reviewer The reviewer to be updated
     * @return Confirms if a reviewer was updated successfully
     */
    public boolean updateReviewer(Reviewer reviewer) {
        DbWrapper dbWrapper = new DbWrapper();
        return dbWrapper.manipulate("CALL update_reviewer(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[]{reviewer.getId(),
            reviewer.getName(),
            reviewer.getUsername(),
            reviewer.getPassword(),
            reviewer.getEmail(),
            reviewer.getRoleId(),
            reviewer.getNif(),
            reviewer.getPhone(),
            reviewer.getAddress(),
            reviewer.getGraduation(),
            reviewer.getSpecialization()}) > 0;
    }

    /**
     * Deletes a reviewer
     *
     * @param reviewer The reviewer to be deleted
     * @return Confirms if a reviewer was deleted successfully
     */
    public boolean deleteReviewer(Reviewer reviewer) {
        return true;
    }
}
