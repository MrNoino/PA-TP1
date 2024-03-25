package tp1.model;

import java.time.LocalDate;

/**
 *
 */
public class Log {
    private long userId;
    private String datetime;
    private String action;

    public Log(long aUserId, String aDatetime, String aAction) {
        this.userId = aUserId;
        this.datetime = aDatetime;
        this.action = aAction;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
