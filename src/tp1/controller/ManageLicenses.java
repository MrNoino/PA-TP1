package tp1.controller;

import java.util.ArrayList;
import tp1.model.DbWrapper;
import tp1.model.License;

/**
 * A class to manage licenses on the database
 */
public class ManageLicenses {

    private ArrayList<License> licenses;

    public ManageLicenses() {
        licenses = new ArrayList<License>();
    }

    /**
     *
     * @return Returns a list of licenses
     */
    public ArrayList<License> getLicenses() {
        return this.licenses;
    }

    /**
     * Insert a license in the database
     *
     * @param license The license to be inserted in the database
     * @return Confirms if a license was inserted successfully
     */
    public boolean insertLicense(License license) {
        return true;
    }

    /**
     * Updates a license quantity in the database
     *
     * @param quantity tge amount to be updated
     * @return Confirms if the quantity was updated successfully
     */
    public boolean updateLicenseQuantity(int quantity) {
        DbWrapper dbWrapper = new DbWrapper();
        return true;
    }
}
