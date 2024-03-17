package tp1.model;

import java.time.LocalDate;

/**
 *
 */
public class Review {
    private long id;
    private String serialNumber;
    private LocalDate completionDate;
    private int elapsedTime;
    private String observations;
    private float cost;
    private int bookId;
    private int authorId;
    private int managerId;
    private int reviewerId;
    private String status;

    public Review(long aId, String aSerialNumber, LocalDate aCompletionDate, int aElapsedTime, String aObservations, float aCost, int aBookId, int aAuthorId, int aManagerId, int aReviewerId, String aStatus) {
        this.id = aId;
        this.serialNumber = aSerialNumber;
        this.completionDate = aCompletionDate;
        this.elapsedTime = aElapsedTime;
        this.observations = aObservations;
        this.cost = aCost;
        this.bookId = aBookId;
        this.authorId = aAuthorId;
        this.managerId = aManagerId;
        this.reviewerId = aReviewerId;
        this.status = aStatus;
    }
}
