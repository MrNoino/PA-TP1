package tp1.controller;

import java.util.ArrayList;
import tp1.model.License;

/**
 *
 * @author lighttigerXIV
 */
public class ManageLicenses {

    private ArrayList<License> licenses;

    public ManageLicenses() {
        licenses = new ArrayList<License>();
    }

    public ArrayList<License> getLicenses() {
        return this.licenses;
    }

    public boolean addLicense(License license) {
        return true;
    }

    public boolean updateLicense(License license) {
        return true;
    }

    public boolean deleteLicense(License license) {
        return true;
    }
}
