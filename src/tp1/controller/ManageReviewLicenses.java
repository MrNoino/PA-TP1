package tp1.controller;

import java.util.ArrayList;
import tp1.model.ReviewLicense;

/**
 *
 * @author lighttigerXIV
 */
public class ManageReviewLicenses {

    private ArrayList<ReviewLicense> reviewLicenses;

    public ManageReviewLicenses() {
        reviewLicenses = new ArrayList<ReviewLicense>();
    }

    public ArrayList<ReviewLicense> getReviewLicenses() {
        return this.reviewLicenses;
    }

    public boolean addReviewLicense(ReviewLicense reviewLicense) {
        return true;
    }

    public boolean updateReviewLicense(ReviewLicense reviewLicense) {
        return true;
    }

    public boolean deleteReviewLicense(ReviewLicense reviewLicense) {
        return true;
    }
}
