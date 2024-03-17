package tp1.model;

import java.time.LocalDate;

/**
 *
 */
public class Note {
    private long id;
    private String description;
    private int page;
    private int paragraph;
    private LocalDate date;
    private long reviewId;

    public Note(long aId, String aDescription, int aPage, int aParagraph, LocalDate aDate, long aReviewId) {
        this.id = aId;
        this.description = aDescription;
        this.page = aPage;
        this.paragraph = aParagraph;
        this.date = aDate;
        this.reviewId = aReviewId;
    }
}
