package tp1.model;

import java.time.LocalDate;

/**
 *
 */
public class License {
    private int id;
    private String designation;
    private LocalDate expireDate;
    private int quantity;

    public License(int aId, String aDesignation, LocalDate aExpireDate, int aQuantity) {
        this.id = aId;
        this.designation = aDesignation;
        this.expireDate = aExpireDate;
        this.quantity = aQuantity;
    }
}
