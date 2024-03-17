package tp1.model;

import java.io.Serializable;

/**
 * A class that represents an User
 */
public class User {
    private long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private boolean active;
    private boolean deleted;
    private int roleId;

    /**
     * Class constutor that assigns the attributes
     * @param aId id of the user
     * @param aName name of the user
     * @param aUsername username of the user
     * @param aPassword password of the user
     * @param aEmail email of the user
     * @param aActive if user is active
     * @param aDeleted if user was deleted
     * @param aRoleId role id of the user
     */
    public User(long aId, String aName, String aUsername, String aPassword, String aEmail, boolean aActive, boolean aDeleted, int aRoleId) {
        this.id = aId;
        this.name = aName;
        this.username = aUsername;
        this.password = aPassword;
        this.email = aEmail;
        this.active = aActive;
        this.deleted = aDeleted;
        this.roleId = aRoleId;
    }
    
    /**
     * Class constutor that assigns the attributes except password
     * @param aId id of the user
     * @param aName name of the user
     * @param aUsername username of the user
     * @param aEmail email of the user
     * @param aActive if user is active
     * @param aDeleted if user was deleted
     * @param aRoleId role id of the user
     */
    public User(long aId, String aName, String aUsername, String aEmail, boolean aActive, boolean aDeleted, int aRoleId) {
        this.id = aId;
        this.name = aName;
        this.username = aUsername;
        this.password = null;
        this.email = aEmail;
        this.active = aActive;
        this.deleted = aDeleted;
        this.roleId = aRoleId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
