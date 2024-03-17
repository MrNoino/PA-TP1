package tp1.model;

import java.time.LocalDate;

/**
 *
 */
public class Log {
    int userId;
    LocalDate datetime;
    String action;

    public Log(int aUserId, LocalDate aDatetime, String aAction) {
        this.userId = aUserId;
        this.datetime = aDatetime;
        this.action = aAction;
    }
}
