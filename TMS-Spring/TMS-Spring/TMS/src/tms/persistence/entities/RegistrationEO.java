package tms.persistence.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "REGISTRATIONS")
@NamedQuery(name = "Registrations.findAll", query = "SELECT regRef FROM RegistrationEO regRef")
public class RegistrationEO {

    @Id
    @Column(name = "REGISTRATION_ID")
    private String registrationID;

    @JoinColumn(name = "VEHICLE_ID", referencedColumnName = "VEHICLE_ID", nullable = false)
    @OneToOne
    private VehicleEO vehicle;

    @JoinColumn(name = "OWNER_ID", referencedColumnName = "OWNER_ID", nullable = false)
    @OneToOne
    private OwnerEO owner;

    @Column(name = "REGISTRATION_DATE", nullable = false)
    private Date registrationDate;

    public RegistrationEO() {
        super();
    }

    /**
     * @param registrationID
     * @param vehicle
     * @param owner
     * @param registrationDate
     */
    public RegistrationEO(String registrationID, VehicleEO vehicle,
                          OwnerEO owner, Date registrationDate) {
        super();
        this.registrationID = registrationID;
        this.vehicle = vehicle;
        this.owner = owner;
        this.registrationDate = registrationDate;
    }

    /**
     * @param registrationID
     */
    public void setRegistrationID(String registrationID) {
        this.registrationID = registrationID;
    }

    /**
     * @return
     */
    public String getRegistrationID() {
        return registrationID;
    }

    /**
     * @param vehicle
     */
    public void setVehicle(VehicleEO vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * @return
     */
    public VehicleEO getVehicle() {
        return vehicle;
    }

    /**
     * @param owner
     */
    public void setOwner(OwnerEO owner) {
        this.owner = owner;
    }

    /**
     * @return
     */
    public OwnerEO getOwner() {
        return owner;
    }

    /**
     * @param registrationDate
     */
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * @return
     */
    public Date getRegistrationDate() {
        return registrationDate;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "RegistrationEO [registrationID : " + this.registrationID +
            "vehicleID : " + this.vehicle + "ownerID : " + this.owner +
            "registrationDate : " + this.registrationDate;
    }
}
