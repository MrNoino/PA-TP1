package tp1.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import tp1.model.DbWrapper;
import tp1.model.Review;

/**
 * A class to manage reviews on the database
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
    public boolean addReview(Long bookId, Long authorId) {
        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();
        
        ResultSet resultSet = dbWrapper.query("CALL get_reviews_max_id()");
        Long maxId = 0L;
        
        try {
            if(resultSet == null)
                return false;
            
            while(resultSet.next()){
                maxId = resultSet.getLong("max");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        String serialNumber = (maxId + 1) + formatter.format(now);
        
        return dbWrapper.manipulate("CALL insert_review(?, ?, ?)", new Object[]{serialNumber, bookId, authorId}) > 0;
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
