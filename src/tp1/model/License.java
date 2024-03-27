package tp1.model;

import java.time.LocalDate;

/**
 *
 */
public class License {
    private int id;
    private String designation;
    private String expireDate;
    private int quantity;

    public License(int aId, String aDesignation, String aExpireDate, int aQuantity) {
        this.id = aId;
        this.designation = aDesignation;
        this.expireDate = aExpireDate;
        this.quantity = aQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
