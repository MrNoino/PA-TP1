package tp1.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import tp1.model.DbWrapper;
import tp1.model.Log;
import tp1.model.Review;
import tp1.view.Main;

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

    public void listReviews(long authorId, String sortType, String searchType, String search) {
        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();

        ResultSet resultSet;

        if (sortType != null) {
            resultSet = dbWrapper.query("CALL get_reviews_by_author(?, ?, 1)", new Object[]{authorId, sortType});
        } else {
            resultSet = dbWrapper.query("CALL search_author_reviews_by_" + searchType + "(?, ?)", new Object[]{authorId, search});
        }

        try {
            if (resultSet == null) {
                return;
            }
            if (Main.getLoggedUser() != null) {
                new ManageLogs().insertLog(new Log(Main.getLoggedUser().getId(),
                        new SimpleDateFormat("yyyy-mm-dd").format(new java.util.Date()),
                        "Listou Revisões"));
            }
            System.out.println("Data de submissão\t\tNúmero de série\t\tTítulo\t\tStatus\n");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("submission_date")
                        + "\t\t" + resultSet.getString("serial_number")
                        + "\t\t" + resultSet.getString("title")
                        + "\t\t" + resultSet.getString("status"));
            }
            
            System.out.println();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Inserts a review in the database
     *
     * @param bookId book id associated to the review
     * @param authorId author id associated to the review
     * @return Confirms if a review was inserted successfully
     */
    public boolean insertReview(Long bookId, Long authorId) {
        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();

        ResultSet resultSet = dbWrapper.query("CALL get_reviews_max_id()");
        Long maxId = 0L;

        try {
            if (resultSet == null) {
                return false;
            }
            
            while (resultSet.next()) {
                maxId = resultSet.getLong("max");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        String serialNumber = (maxId + 1) + formatter.format(now);

        boolean inserted = dbWrapper.manipulate("CALL insert_review(?, ?, ?)", new Object[]{serialNumber, bookId, authorId}) > 0;
        
        if (inserted && Main.getLoggedUser() != null) {
            new ManageLogs().insertLog(new Log(Main.getLoggedUser().getId(),
                    new SimpleDateFormat("yyyy-mm-dd").format(new java.util.Date()),
                    "Inseriu Revisão"));
        }
        
        return inserted;
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
