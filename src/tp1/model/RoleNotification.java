package tp1.model;

import java.time.LocalDate;

/**
 *
 * @author lighttigerXIV
 */
public class RoleNotification {
    long id;
    boolean read;
    String content;
    LocalDate datetime;
    int roleId;

    public RoleNotification(long aId, boolean aRead, String aContent, LocalDate aDatetime, int aRoleId) {
        this.id = aId;
        this.read = aRead;
        this.content = aContent;
        this.datetime = aDatetime;
        this.roleId = aRoleId;
    }
}
