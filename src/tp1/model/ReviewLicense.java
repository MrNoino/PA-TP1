package tp1.model;

/**
 *
 * @author lighttigerXIV
 */
public class ReviewLicense {
    int licenseId;
    long reviewId;

    public ReviewLicense(int aLicenseId, long aReviewId) {
        this.licenseId = aLicenseId;
        this.reviewId = aReviewId;
    }
}
