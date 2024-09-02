package tms.persistence;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
  @NamedQuery(name = "Registrations.findAll", query = "select o from Registrations o")
})
public class Registrations implements Serializable {
    @Column(name="REGISTRATION_DATE", nullable = false)
    private Timestamp registrationDate;
    @Id
    @Column(name="REGISTRATION_ID", nullable = false, length = 13)
    private String registrationId;
    //@OneToMany(mappedBy = "registrations")
    //private List<OffenseDetails> offenseDetailsList;
    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private Owners owners;
    @ManyToOne
    @JoinColumn(name = "VEHICLE_ID")
    private Vehicles vehicles;

    public Registrations() {
    }

    public Registrations(Owners owners, Timestamp registrationDate,
                         String registrationId, Vehicles vehicles) {
        this.owners = owners;
        this.registrationDate = registrationDate;
        this.registrationId = registrationId;
        this.vehicles = vehicles;
    }


    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }


    /*public List<OffenseDetails> getOffenseDetailsList() {
        return offenseDetailsList;
    }

    public void setOffenseDetailsList(List<OffenseDetails> offenseDetailsList) {
        this.offenseDetailsList = offenseDetailsList;
    }

    public OffenseDetails addOffenseDetails(OffenseDetails offenseDetails) {
        getOffenseDetailsList().add(offenseDetails);
        offenseDetails.setRegistrations(this);
        return offenseDetails;
    }

    public OffenseDetails removeOffenseDetails(OffenseDetails offenseDetails) {
        getOffenseDetailsList().remove(offenseDetails);
        offenseDetails.setRegistrations(null);
        return offenseDetails;
    }*/

    public Owners getOwners() {
        return owners;
    }

    public void setOwners(Owners owners) {
        this.owners = owners;
    }

    public Vehicles getVehicles() {
        return vehicles;
    }

    public void setVehicles(Vehicles vehicles) {
        this.vehicles = vehicles;
    }
    
    @Override
    public String toString() {
        return "Registrations [registrationDate=" + registrationDate + ", registrationId=" + registrationId +
               owners + vehicles + "]";
    }
        
}
