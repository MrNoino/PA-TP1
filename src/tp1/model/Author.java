package tp1.model;

/**
 * A class that represents an Author
 */
public class Author extends User{
    private String nif;
    private String phone;
    private String address;
    private String activityBeginDate;
    private int literaryStyleId;

    /**
     * Class construtor that assigns the attributes
     * @param aId id of the author
     * @param aName name of the author
     * @param aUsername username of the author
     * @param aPassword password of the author
     * @param aEmail email of the author
     * @param aActive if author is active
     * @param aDeleted if author was deleted
     * @param aRoleId role id of the author
     * @param aNif NIF of the author
     * @param aPhone phone number of the author
     * @param aAddress address of the author
     * @param aActivityBeginDate date of the begin activity of the author
     * @param aLiteraryStyleId literacy style id of the author
     */
    public Author(long aId, String aName, String aUsername, String aPassword, String aEmail, boolean aActive, boolean aDeleted, int aRoleId, String aNif, String aPhone, String aAddress, String aActivityBeginDate, int aLiteraryStyleId) {
        super(aId, aName, aUsername, aPassword, aEmail, aActive, aDeleted, aRoleId);
        this.nif = aNif;
        this.phone = aPhone;
        this.address = aAddress;
        this.activityBeginDate = aActivityBeginDate;
        this.literaryStyleId = aLiteraryStyleId;
    }
    
    /**
     * Class construtor that assigns the attributes except password
     * @param aId id of the author
     * @param aName name of the author
     * @param aUsername username of the author
     * @param aEmail email of the author
     * @param aActive if author is active
     * @param aDeleted if author was deleted
     * @param aRoleId role id of the author
     * @param aNif NIF of the author
     * @param aPhone phone number of the author
     * @param aAddress address of the author
     * @param aActivityBeginDate date of the begin activity of the author
     * @param aLiteraryStyleId literacy style id of the author
     */
    public Author(long aId, String aName, String aUsername, String aEmail, boolean aActive, boolean aDeleted, int aRoleId, String aNif, String aPhone, String aAddress, String aActivityBeginDate, int aLiteraryStyleId) {
        this(aId, aName, aUsername, null, aEmail, aActive, aDeleted, aRoleId, aNif, aPhone, aAddress, aActivityBeginDate, aLiteraryStyleId);
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

    public String getActivityBeginDate() {
        return activityBeginDate;
    }

    public void setActivityBeginDate(String activityBeginDate) {
        this.activityBeginDate = activityBeginDate;
    }

    public int getLiteraryStyleId() {
        return this.literaryStyleId;
    }

    public void setLiteraryStyleId(int literaryStyleId) {
        this.literaryStyleId = literaryStyleId;
    }
}
