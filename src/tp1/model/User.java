package tp1.model;

import java.io.Serializable;

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
    
    
    
}
