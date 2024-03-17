package tp1.controller;

import java.util.ArrayList;
import tp1.model.DbWrapper;
import tp1.model.Reviewer;

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
     * Updates a reviewer
     *
     * @param reviewer The reviewer to be updated
     * @return Confirms if a reviewer was updated successfully
     */
    public boolean updateReviewer(Reviewer reviewer) {
        return true;
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
