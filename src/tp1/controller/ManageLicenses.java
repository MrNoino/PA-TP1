package tp1.controller;

import java.util.ArrayList;
import tp1.model.License;

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
     * Adds a license
     *
     * @param license The license to add to the list
     * @return Confirms if a license was added successfully
     */
    public boolean addLicense(License license) {
        return true;
    }

    /**
     * Updates a license
     *
     * @param license The license to be updated
     * @return Confirms if a license was updated successfully
     */
    public boolean updateLicense(License license) {
        return true;
    }

    /**
     * Deletes a license
     *
     * @param license The license to be deleted
     * @return Confirms if a license was deleted successfully
     */
    public boolean deleteLicense(License license) {
        return true;
    }
}
