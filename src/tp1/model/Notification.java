package tp1.model;

import java.time.LocalDate;

/**
 *
 */
public class Notification {

    long id;
    long userId;
    boolean read;
    String content;
    LocalDate datetime;

    public Notification(long aId, long aUserId, boolean aRead, String aContent, LocalDate aDatetime) {
        this.id = aId;
        this.userId = aUserId;
        this.read = aRead;
        this.content = aContent;
        this.datetime = aDatetime;
    }
}
