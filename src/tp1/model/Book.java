package tp1.model;
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
    private String submissionDate;
    private String approvalDate;
    private int literacyStyleId;
    private String publicationType;
    private long authorId;

    public Book(long aId, String aTitle, String aSubtitle, int aPages, int aWords, String aIsbn, String aEdition, String aSubmissionDate, String aApprovalDate, int aLiteracyStyleId, String aPublicationType, long aAuthorId) {
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
    
    public Book(long aId, String aTitle, String aSubtitle, int aPages, int aWords, String aIsbn, String aEdition, String aSubmissionDate, int aLiteracyStyleId, String aPublicationType, long aAuthorId){
        this(aId, aTitle, aSubtitle, aPages, aWords, aIsbn, aEdition, aSubmissionDate, null, aLiteracyStyleId, aPublicationType, aAuthorId);
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public int getPages() {
        return pages;
    }

    public int getWords() {
        return words;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getEdition() {
        return edition;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public int getLiteracyStyleId() {
        return literacyStyleId;
    }

    public String getPublicationType() {
        return publicationType;
    }

    public long getAuthorId() {
        return authorId;
    }
    
    
    
}
