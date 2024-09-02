package tms.persistence.entity;

import java.sql.Date;

public class RegistrationEO {

    private String registrationID;
    private VehicleEO vehicle;
    private OwnerEO owner;
    private Date registrationDate;

    public RegistrationEO() {

    }

    public RegistrationEO(String registrationID, VehicleEO vehicle,
                          OwnerEO owner, Date registrationDate) {
        super();
        this.registrationID = registrationID;
        this.vehicle = vehicle;
        this.owner = owner;
        this.registrationDate = registrationDate;
    }

    public void setRegistrationID(String registrationID) {
        this.registrationID = registrationID;
    }

    public String getRegistrationID() {
        return registrationID;
    }

    public void setVehicle(VehicleEO vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleEO getVehicle() {
        return vehicle;
    }

    public void setOwner(OwnerEO owner) {
        this.owner = owner;
    }

    public OwnerEO getOwner() {
        return owner;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public String toString() {
        return "RegistrationEO contains: [registrationID: " +
            this.registrationID + " vehicleID: " +
            this.vehicle.getVehicleID() + " ownerID: " +
            this.owner.getOwnerID() + " registrationDate: " +
            this.registrationDate + "]";
    }

}
