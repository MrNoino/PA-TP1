package tp1.model;

import java.time.LocalDate;

/**
 *
 * @author lighttigerXIV
 */
public class Book {
    long id;
    String title;
    String subtitle;
    int pages;
    int words;
    String isbn;
    String edition;
    LocalDate submissionDate;
    LocalDate approvalDate;
    int literacyStyleId;
    String publicationType;
    int authorId;

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
