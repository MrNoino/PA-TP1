package tp1.model;

import java.time.LocalDate;

/**
 *
 */
public class Review {
    private long id;
    private String serialNumber;
    private String submissionDate;
    private String completionDate;
    private int elapsedTime;
    private String observations;
    private float cost;
    private Book book;
    private long authorId;
    private long managerId;
    private long reviewerId;
    private String status;

    public Review(long aId, String aSerialNumber, String aSubmissionDate, String aCompletionDate, int aElapsedTime, String aObservations, float aCost, Book aBook, long aAuthorId, long aManagerId, long aReviewerId, String aStatus) {
        this.id = aId;
        this.serialNumber = aSerialNumber;
        this.submissionDate = aSubmissionDate;
        this.completionDate = aCompletionDate;
        this.elapsedTime = aElapsedTime;
        this.observations = aObservations;
        this.cost = aCost;
        this.book = aBook;
        this.authorId = aAuthorId;
        this.managerId = aManagerId;
        this.reviewerId = aReviewerId;
        this.status = aStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public int getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(int elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public long getManagerId() {
        return managerId;
    }

    public void setManagerId(long managerId) {
        this.managerId = managerId;
    }

    public long getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(long reviewerId) {
        this.reviewerId = reviewerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
