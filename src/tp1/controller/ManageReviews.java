package tp1.controller;

import java.util.ArrayList;
import tp1.model.Review;

/**
 *
 * @author lighttigerXIV
 */
public class ManageReviews {

    private ArrayList<Review> reviews;

    public ManageReviews() {
        reviews = new ArrayList<Review>();
    }

    public ArrayList<Review> getReviews() {
        return this.reviews;
    }

    public boolean addReview(Review review) {
        return true;
    }

    public boolean updateReview(Review review) {
        return true;
    }

    public boolean deleteReview(Review review) {
        return true;
    }
}
