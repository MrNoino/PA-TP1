package tp1.model;

import java.time.LocalDate;

/**
 *
 */
public class Log {
    private int userId;
    private LocalDate datetime;
    private String action;

    public Log(int aUserId, LocalDate aDatetime, String aAction) {
        this.userId = aUserId;
        this.datetime = aDatetime;
        this.action = aAction;
    }
}
