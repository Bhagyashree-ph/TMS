package tms.persistence.entity;

import java.sql.*;

public class OffenceDetailEO {

    private String offenseDetailID;
    private Timestamp offenseDateTime;
    private String place;
    private byte[] image;
    private RegistrationEO registration;
    private OffenceTypeEO offense;
    private UserEO user;
    private String penaltyStatus;

    public OffenceDetailEO() {

    }

    public OffenceDetailEO(String offenseDetailID, Timestamp offenseDateTime,
                           String place, byte[] image,
                           RegistrationEO registration, OffenceTypeEO offense,
                           UserEO user, String penaltyStatus) {
        super();
        this.offenseDetailID = offenseDetailID;
        this.offenseDateTime = offenseDateTime;
        this.place = place;
        this.image = image;
        this.registration = registration;
        this.offense = offense;
        this.user = user;
        this.penaltyStatus = penaltyStatus;
    }

    public void setOffenseDetailID(String offenseDetailID) {
        this.offenseDetailID = offenseDetailID;
    }

    public String getOffenseDetailID() {
        return offenseDetailID;
    }

    public void setOffenseDateTime(Timestamp offenseDateTime) {
        this.offenseDateTime = offenseDateTime;
    }

    public Timestamp getOffenseDateTime() {
        return offenseDateTime;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getImage() {
        return image;
    }

    public void setRegistration(RegistrationEO registration) {
        this.registration = registration;
    }

    public RegistrationEO getRegistration() {
        return registration;
    }

    public void setOffense(OffenceTypeEO offense) {
        this.offense = offense;
    }

    public OffenceTypeEO getOffense() {
        return offense;
    }

    public void setUser(UserEO user) {
        this.user = user;
    }

    public UserEO getUser() {
        return user;
    }

    public void setPenaltyStatus(String penaltyStatus) {
        this.penaltyStatus = penaltyStatus;
    }

    public String getPenaltyStatus() {
        return penaltyStatus;
    }

    @Override
    public String toString() {
        return "OffenseDetailEO contains: [offenseDetailID: " +
            this.offenseDetailID + " offenseDateTime: " +
            this.offenseDateTime + " place: " + this.place + " iamge: " +
            this.image + " registrationID: " +
            this.registration.getRegistrationID() + " offenseID: " +
            this.offense.getOffenseID() + " recordedBy: " +
            this.user.getUserID() + " penaltyStatus: " + this.penaltyStatus +
            "]";
    }
}
