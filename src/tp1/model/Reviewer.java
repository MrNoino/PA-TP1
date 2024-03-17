package tp1.model;

/**
 *
 */
public class Reviewer {
    int userId;
    String nif;
    String phone;
    String address;
    String graduation;
    String specialization;

    public Reviewer(int aUserId, String aNif, String aPhone, String aAddress, String aGraduation, String aSpecialization) {
        this.userId = aUserId;
        this.nif = aNif;
        this.phone = aPhone;
        this.address = aAddress;
        this.graduation = aGraduation;
        this.specialization = aSpecialization;
    }
}
