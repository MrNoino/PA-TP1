package tp1.model;

/**
 *
 * @author lighttigerXIV
 */
public class Author {
    long userId;
    String nif;
    String phone;
    String address;
    String activityBeginDate;
    int literacyStyleId;

    public Author(long aUserId, String aNif, String aPhone, String aAddress, String aActivityBeginDate, int aLiteracyStyleId) {
        this.userId = aUserId;
        this.nif = aNif;
        this.phone = aPhone;
        this.address = aAddress;
        this.activityBeginDate = aActivityBeginDate;
        this.literacyStyleId = aLiteracyStyleId;
    }
}
