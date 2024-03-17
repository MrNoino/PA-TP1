package tp1.model;

/**
 * A class that represents a Reviewer
 */
public class Reviewer extends User{
    private String nif;
    private String phone;
    private String address;
    private String graduation;
    private String specialization;

    /**
     * Class constutor that assigns the attributes
     * @param aId id of the reviewer
     * @param aName name of the reviewer
     * @param aUsername username of the reviewer
     * @param aPassword password of the reviewer
     * @param aEmail email of the reviewer
     * @param aActive if reviewer is active
     * @param aDeleted if reviewer was deleted
     * @param aRoleId role id of the reviewer
     * @param aNif NIF of the reviewer
     * @param aPhone phone number of the reviewer
     * @param aAddress address of the reviewer
     * @param aGraduation graduation of the reviewer
     * @param aSpecialization specialization of the reviewer
     */
    public Reviewer(long aId, String aName, String aUsername, String aPassword, String aEmail, boolean aActive, boolean aDeleted, int aRoleId, String aNif, String aPhone, String aAddress, String aGraduation, String aSpecialization) {
        super(aId, aName, aUsername, aPassword, aEmail, aActive, aDeleted, aRoleId);
        this.nif = aNif;
        this.phone = aPhone;
        this.address = aAddress;
        this.graduation = aGraduation;
        this.specialization = aSpecialization;
    }
    
    /**
     * Class constutor that assigns the attributes except password
     * @param aId id of the reviewer
     * @param aName name of the reviewer
     * @param aUsername username of the reviewer
     * @param aEmail email of the reviewer
     * @param aActive if reviewer is active
     * @param aDeleted if reviewer was deleted
     * @param aRoleId role id of the reviewer
     * @param aNif NIF of the reviewer
     * @param aPhone phone number of the reviewer
     * @param aAddress address of the reviewer
     * @param aGraduation graduation of the reviewer
     * @param aSpecialization specialization of the reviewer
     */
    public Reviewer(long aId, String aName, String aUsername, String aEmail, boolean aActive, boolean aDeleted, int aRoleId, String aNif, String aPhone, String aAddress, String aGraduation, String aSpecialization) {
        this(aId, aName, aUsername, null, aEmail, aActive, aDeleted, aRoleId, aNif, aPhone, aAddress, aGraduation, aSpecialization);
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
}
    
