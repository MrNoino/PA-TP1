package tp1.model;

import java.time.LocalDate;

/**
 *
 */
public class Log {
    private long id;
    private long userId;
    private String datetime;
    private String action;

    public Log(long aId, long aUserId, String aDatetime, String aAction) {
        this.id = aId;
        this.userId = aUserId;
        this.datetime = aDatetime;
        this.action = aAction;
    }
    
    public Log(long aUserId, String aDatetime, String aAction) {
        this.id = -1;
        this.userId = aUserId;
        this.datetime = aDatetime;
        this.action = aAction;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
