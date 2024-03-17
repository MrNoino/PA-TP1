package tp1.model;

import java.time.LocalDate;

/**
 *
 */
public class License {
    int id;
    String designation;
    LocalDate expireDate;
    int quantity;

    public License(int aId, String aDesignation, LocalDate aExpireDate, int aQuantity) {
        this.id = aId;
        this.designation = aDesignation;
        this.expireDate = aExpireDate;
        this.quantity = aQuantity;
    }
}
