package tp1.model;

import java.time.LocalDate;

/**
 *
 * @author lighttigerXIV
 */
public class Note {
    long id;
    String description;
    int page;
    int paragraph;
    LocalDate date;
    long reviewId;

    public Note(long aId, String aDescription, int aPage, int aParagraph, LocalDate aDate, long aReviewId) {
        this.id = aId;
        this.description = aDescription;
        this.page = aPage;
        this.paragraph = aParagraph;
        this.date = aDate;
        this.reviewId = aReviewId;
    }
}
