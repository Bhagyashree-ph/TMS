package tms.persistence;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
  @NamedQuery(name = "Vehicles.findAll", query = "select o from Vehicles o")
})
public class Vehicles implements Serializable {
    @Column(name="CHASSIS_NUMBER", unique = true, length = 30)
    private String chassisNumber;
    @Column(name="ENGINE_NUMBER", nullable = false, unique = true, length = 30)
    private String engineNumber;
    @Column(name="FUEL_USED", length = 20)
    private String fuelUsed;
    @Column(name="MANUFACTURER_NAME", length = 20)
    private String manufacturerName;
    @Column(name="MANUFACTURE_DATE", nullable = false)
    private Timestamp manufactureDate;
    @Column(nullable = false, length = 30)
    private String model;
    @Column(nullable = false, unique = true, length = 50)
    private String variant;
    @Id
    @Column(name="VEHICLE_ID", nullable = false)
    private Long vehicleId;
    @Column(name="VEHICLE_TYPE", nullable = false, length = 20)
    private String vehicleType;
    @Column(name="VEH_COLOR", length = 20)
    private String vehColor;
    //@OneToMany(mappedBy = "vehicles")
    //private List<Registrations> registrationsList;

    public Vehicles() {
    }

    public Vehicles(String chassisNumber, String engineNumber, String fuelUsed,
                    Timestamp manufactureDate, String manufacturerName,
                    String model, String variant, String vehColor,
                    Long vehicleId, String vehicleType) {
        this.chassisNumber = chassisNumber;
        this.engineNumber = engineNumber;
        this.fuelUsed = fuelUsed;
        this.manufactureDate = manufactureDate;
        this.manufacturerName = manufacturerName;
        this.model = model;
        this.variant = variant;
        this.vehColor = vehColor;
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getFuelUsed() {
        return fuelUsed;
    }

    public void setFuelUsed(String fuelUsed) {
        this.fuelUsed = fuelUsed;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public Timestamp getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Timestamp manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehColor() {
        return vehColor;
    }

    public void setVehColor(String vehColor) {
        this.vehColor = vehColor;
    }

    /*public List<Registrations> getRegistrationsList() {
        return registrationsList;
    }

    public void setRegistrationsList(List<Registrations> registrationsList) {
        this.registrationsList = registrationsList;
    }

    public Registrations addRegistrations(Registrations registrations) {
        getRegistrationsList().add(registrations);
        registrations.setVehicles(this);
        return registrations;
    }

    public Registrations removeRegistrations(Registrations registrations) {
        getRegistrationsList().remove(registrations);
        registrations.setVehicles(null);
        return registrations;
    }*/
    
    @Override
    public String toString() {
        return "Vehicles [chassisNumber=" + chassisNumber + ", engineNumber=" + engineNumber + ", fuelUsed=" + fuelUsed
            + ", manufacturerName=" + manufacturerName + ", manufactureDate=" + manufactureDate + ", model=" + model
            + ", variant=" + variant + ", vehicleId=" + vehicleId + ", vehicleType=" + vehicleType + ", vehColor="
            + vehColor + "]";
    }

}
