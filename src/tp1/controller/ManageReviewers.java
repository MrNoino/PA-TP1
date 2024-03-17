package tp1.controller;

import java.util.ArrayList;
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
     * Adds a reviewer
     *
     * @param reviewer The reviewer to add to the list
     * @return Confirms if a reviewer was added successfully
     */
    public boolean addReviewer(Reviewer reviewer) {
        return true;
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
