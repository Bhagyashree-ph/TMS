package tms.persistence;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({
  @NamedQuery(name = "OffenseTypes.findAll", query = "select o from OffenseTypes o")
})
@Table(name = "OFFENSE_TYPES")
public class OffenseTypes implements Serializable {
    @Id
    @Column(name="OFFENSE_ID", nullable = false, length = 10)
    private String offenseId;
    @Column(name="OFFENSE_NAME", nullable = false, length = 50)
    private String offenseName;
    @Column(nullable = false)
    private Double penalty;
    @Column(name="VEHICLE_TYPE", nullable = false, length = 50)
    private String vehicleType;
    //@OneToMany(mappedBy = "offenseTypes")
    //private List<OffenseDetails> offenseDetailsList;

    public OffenseTypes() {
    }

    public OffenseTypes(String offenseId, String offenseName, Double penalty,
                        String vehicleType) {
        this.offenseId = offenseId;
        this.offenseName = offenseName;
        this.penalty = penalty;
        this.vehicleType = vehicleType;
    }

    public String getOffenseId() {
        return offenseId;
    }

    public void setOffenseId(String offenseId) {
        this.offenseId = offenseId;
    }

    public String getOffenseName() {
        return offenseName;
    }

    public void setOffenseName(String offenseName) {
        this.offenseName = offenseName;
    }

    public Double getPenalty() {
        return penalty;
    }

    public void setPenalty(Double penalty) {
        this.penalty = penalty;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    /*public List<OffenseDetails> getOffenseDetailsList() {
        return offenseDetailsList;
    }

    public void setOffenseDetailsList(List<OffenseDetails> offenseDetailsList) {
        this.offenseDetailsList = offenseDetailsList;
    }

    public OffenseDetails addOffenseDetails(OffenseDetails offenseDetails) {
        getOffenseDetailsList().add(offenseDetails);
        offenseDetails.setOffenseTypes(this);
        return offenseDetails;
    }

    public OffenseDetails removeOffenseDetails(OffenseDetails offenseDetails) {
        getOffenseDetailsList().remove(offenseDetails);
        offenseDetails.setOffenseTypes(null);
        return offenseDetails;
    }*/
    
    @Override
    public String toString() {
        return "OffenseTypes [offenseId=" + offenseId + ", offenseName=" + offenseName + ", penalty=" + penalty
            + ", vehicleType=" + vehicleType + "]";
    }
}
