package tp1.model;

import java.time.LocalDate;

/**
 *
 */
public class Book {
    private long id;
    private String title;
    private String subtitle;
    private int pages;
    private int words;
    private String isbn;
    private String edition;
    private LocalDate submissionDate;
    private LocalDate approvalDate;
    private int literacyStyleId;
    private String publicationType;
    private int authorId;

    public Book(long aId, String aTitle, String aSubtitle, int aPages, int aWords, String aIsbn, String aEdition, LocalDate aSubmissionDate, LocalDate aApprovalDate, int aLiteracyStyleId, String aPublicationType, int aAuthorId) {
        this.id = aId;
        this.title = aTitle;
        this.subtitle = aSubtitle;
        this.pages = aPages;
        this.words = aWords;
        this.isbn = aIsbn;
        this.edition = aEdition;
        this.submissionDate = aSubmissionDate;
        this.approvalDate = aApprovalDate;
        this.literacyStyleId = aLiteracyStyleId;
        this.publicationType = aPublicationType;
        this.authorId = aAuthorId;
    }
}
