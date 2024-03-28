package tp1.controller;

import java.util.ArrayList;
import tp1.model.ReviewLicense;

/**
 * A class to manage review license on the database
 */
public class ManageReviewLicenses {

    private ArrayList<ReviewLicense> reviewLicenses;

    /**
     * Class constructor initializing the ArrayList
     */
    public ManageReviewLicenses() {
        reviewLicenses = new ArrayList<ReviewLicense>();
    }

    /**
     *
     * @return Returns a list of review licenses
     */
    public ArrayList<ReviewLicense> getReviewLicenses() {
        return this.reviewLicenses;
    }

    /**
     * Adds a review license
     *
     * @param reviewLicense The review license to add to the list
     * @return Confirms if a review license was added successfully
     */
    public boolean addReviewLicense(ReviewLicense reviewLicense) {
        return true;
    }

    /**
     * Updates a review license
     *
     * @param reviewLicense The review license to be updated
     * @return Confirms if a review license was updated successfully
     */
    public boolean updateReviewLicense(ReviewLicense reviewLicense) {
        return true;
    }

    /**
     * Deletes a review license
     *
     * @param reviewLicense The review license to be deleted
     * @return Confirms if a review license was deleted successfully
     */
    public boolean deleteReviewLicense(ReviewLicense reviewLicense) {
        return true;
    }
}
