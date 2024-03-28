package tp1.model;

import java.time.LocalDate;

/**
 * A class that represents a notification 
 */
public class Notification {

    private long id;
    private long userId;
    private boolean read;
    private String content;
    private LocalDate datetime;

    public Notification(long aId, long aUserId, boolean aRead, String aContent, LocalDate aDatetime) {
        this.id = aId;
        this.userId = aUserId;
        this.read = aRead;
        this.content = aContent;
        this.datetime = aDatetime;
    }
}
