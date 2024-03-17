package tp1.model;

/**
 *
 */
public class User {
    long id;
    String name;
    String username;
    String email;
    boolean active;
    boolean deleted;
    int roleId;

    public User(long aId, String aName, String aUsername, String aEmail, boolean aActive, boolean aDeleted, int aRoleId) {
        this.id = aId;
        this.name = aName;
        this.username = aUsername;
        this.email = aEmail;
        this.active = aActive;
        this.deleted = aDeleted;
        this.roleId = aRoleId;
    }
}
