package tms.persistence;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.Arrays;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
  @NamedQuery(name = "OffenseDetails.findAll", query = "select o from OffenseDetails o")
})
@Table(name = "OFFENSE_DETAILS")
public class OffenseDetails implements Serializable {
    private byte[] image;
    @Column(name="OFFENSE_DATE_TIME")
    private Timestamp offenseDateTime = new Timestamp(new Date().getTime());
    @Id
    @Column(name="OFFENSE_DETAIL_ID", nullable = false, length = 20)
    private String offenseDetailId;
    @Column(name="PENALTY_STATUS", nullable = false, length = 6)
    private String penaltyStatus;
    @Column(length = 200)
    private String place;
    @ManyToOne
    @JoinColumn(name = "OFFENSE_ID")
    private OffenseTypes offenseTypes;
    @ManyToOne
    @JoinColumn(name = "REGISTRATION_ID")
    private Registrations registrations;
    @ManyToOne
    @JoinColumn(name = "RECORDED_BY")
    private Users users;

    public OffenseDetails() {
    }

    public OffenseDetails(Timestamp offenseDateTime, String offenseDetailId,
                          OffenseTypes offenseTypes, String penaltyStatus, String place, Users users,
                          Registrations registrations) {
        this.offenseDateTime = offenseDateTime;
        this.offenseDetailId = offenseDetailId;
        this.offenseTypes = offenseTypes;
        this.penaltyStatus = penaltyStatus;
        this.place = place;
        this.users = users;
        this.registrations = registrations;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Timestamp getOffenseDateTime() {
        return offenseDateTime;
    }

    public void setOffenseDateTime(Timestamp offenseDateTime) {
        System.out.println(offenseDateTime);
        this.offenseDateTime = offenseDateTime;
    }

    public String getOffenseDetailId() {
        return offenseDetailId;
    }

    public void setOffenseDetailId(String offenseDetailId) {
        System.out.println(offenseDetailId);
        this.offenseDetailId = offenseDetailId;
    }

    public String getPenaltyStatus() {
        return penaltyStatus;
    }

    public void setPenaltyStatus(String penaltyStatus) {
        System.out.println(penaltyStatus);
        this.penaltyStatus = penaltyStatus;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        System.out.println(place);
        this.place = place;
    }


    public OffenseTypes getOffenseTypes() {
        return offenseTypes;
    }

    public void setOffenseTypes(OffenseTypes offenseTypes) {
        System.out.println(offenseTypes.getOffenseId());
        this.offenseTypes = offenseTypes;
    }

    public Registrations getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Registrations registrations) {
        System.out.println(registrations.getRegistrationId());
        this.registrations = registrations;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        System.out.println(users.getUserId());
        this.users = users;
    }
    
    @Override
            public String toString() {
                    return "OffenseDetails [offenseDateTime=" + offenseDateTime
                                    + ", offenseDetailId=" + offenseDetailId + ", penaltyStatus=" + penaltyStatus + ", place=" + place
                                    + registrations+users+offenseTypes+"]";
            }
}
