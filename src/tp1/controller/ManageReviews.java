package tp1.controller;

import java.util.ArrayList;
import tp1.model.Review;

/**
 *
 */
public class ManageReviews {

    private ArrayList<Review> reviews;

    public ManageReviews() {
        reviews = new ArrayList<Review>();
    }

    /**
     *
     * @return Returns a list of reviews
     */
    public ArrayList<Review> getReviews() {
        return this.reviews;
    }

    /**
     * Adds a review
     *
     * @param review The review to add to the list
     * @return Confirms if a review was added successfully
     */
    public boolean addReview(Review review) {
        return true;
    }

    /**
     * Updates a review
     *
     * @param review The review to be updated
     * @return Confirms if a review was updated successfully
     */
    public boolean updateReview(Review review) {
        return true;
    }

    /**
     * Deletes a review
     *
     * @param review The review to be deleted
     * @return Confirms if a review was deleted successfully
     */
    public boolean deleteReview(Review review) {
        return true;
    }
}
