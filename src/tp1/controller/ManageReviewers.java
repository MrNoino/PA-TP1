package tp1.controller;

import java.util.ArrayList;
import tp1.model.Reviewer;

/**
 *
 * @author lighttigerXIV
 */
public class ManageReviewers {

    private ArrayList<Reviewer> reviewers;

    public ManageReviewers() {
        reviewers = new ArrayList<Reviewer>();
    }

    public ArrayList<Reviewer> getReviewers() {
        return this.reviewers;
    }

    public boolean addReviewer(Reviewer reviewer) {
        return true;
    }

    public boolean updateReviewer(Reviewer reviewer) {
        return true;
    }

    public boolean deleteReviewer(Reviewer reviewer) {
        return true;
    }
}
