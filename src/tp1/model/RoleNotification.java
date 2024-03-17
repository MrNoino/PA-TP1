package tp1.model;

import java.time.LocalDate;

/**
 *
 */
public class RoleNotification {
    private long id;
    private boolean read;
    private String content;
    private LocalDate datetime;
    private int roleId;

    public RoleNotification(long aId, boolean aRead, String aContent, LocalDate aDatetime, int aRoleId) {
        this.id = aId;
        this.read = aRead;
        this.content = aContent;
        this.datetime = aDatetime;
        this.roleId = aRoleId;
    }
}
