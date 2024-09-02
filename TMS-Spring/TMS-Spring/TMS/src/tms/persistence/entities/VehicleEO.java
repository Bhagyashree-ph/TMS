package tms.persistence.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "VEHICLES")
public class VehicleEO {
    
    @Id
    @Column(name = "VEHICLE_ID")
    @SequenceGenerator(name = "VEH_SEQ", sequenceName = "VEHICLES_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "VEH_SEQ", strategy = GenerationType.SEQUENCE)
    private Integer vehicleID;
    
    @Column(name = "ENGINE_NUMBER", nullable = false, unique = true)
    private String engineNumber;
    
    @Column(name = "CHASSIS_NUMBER", unique = true)
    private String chassisNumber;
    
    @Column(name = "VEHICLE_TYPE", nullable = false)
    private String vehicleType;
    
    @Column(name = "VEH_COLOR")
    private String vehicleColor;
    
    @Column(name = "FUEL_USED")
    private String fuelUsed;
    
    @Column(name = "MANUFACTURE_DATE", nullable = false)
    private Date manufacturDate;
    
    @Column(name = "MANUFACTURER_NAME")
    private String manufacturerName;
    
    @Column(name = "VARIANT", nullable = false, unique = true)
    private String variant;
    
    @Column(name= "MODEL", nullable = false)
    private String model;

    public VehicleEO() {

    }

    /**
     * @param engineNumber
     * @param chassisNumber
     * @param vehicleType
     * @param vehicleBrand
     * @param vehicleColor
     * @param fuelUsed
     * @param manufacturDate
     * @param manufacturerName
     * @param variant
     * @param model
     */
    public VehicleEO(String engineNumber,
                     String chassisNumber, String vehicleType,
                     String vehicleBrand, String vehicleColor, String fuelUsed,
                     Date manufacturDate, String manufacturerName,
                     String variant, String model) {
        super();
        this.engineNumber = engineNumber;
        this.chassisNumber = chassisNumber;
        this.vehicleType = vehicleType;
        this.vehicleColor = vehicleColor;
        this.fuelUsed = fuelUsed;
        this.manufacturDate = manufacturDate;
        this.manufacturerName = manufacturerName;
        this.variant = variant;
        this.model = model;
    }

    /**
     * @return
     */
    public Integer getVehicleID() {
        return vehicleID;
    }

    /**
     * @param engineNumber
     */
    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    /**
     * @return
     */
    public String getEngineNumber() {
        return engineNumber;
    }

    /**
     * @param chassisNumber
     */
    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    /**
     * @return
     */
    public String getChassisNumber() {
        return chassisNumber;
    }

    /**
     * @param vehicleType
     */
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    /**
     * @return
     */
    public String getVehicleType() {
        return vehicleType;
    }

    /**
     * @param vehicleColor
     */
    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    /**
     * @return
     */
    public String getVehicleColor() {
        return vehicleColor;
    }

    /**
     * @param fuelUsed
     */
    public void setFuelUsed(String fuelUsed) {
        this.fuelUsed = fuelUsed;
    }

    /**
     * @return
     */
    public String getFuelUsed() {
        return fuelUsed;
    }

    /**
     * @param manufacturDate
     */
    public void setManufacturDate(Date manufacturDate) {
        this.manufacturDate = manufacturDate;
    }

    /**
     * @return
     */
    public Date getManufacturDate() {
        return manufacturDate;
    }

    /**
     * @param manufacturerName
     */
    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    /**
     * @return
     */
    public String getManufacturerName() {
        return manufacturerName;
    }

    /**
     * @param variant
     */
    public void setVariant(String variant) {
        this.variant = variant;
    }

    /**
     * @return
     */
    public String getVariant() {
        return variant;
    }

    /**
     * 
     * @return
     */
    public String getModel() {
		return model;
	}

    /**
     * 
     * @param model
     */
	public void setModel(String model) {
		this.model = model;
	}

	/**
     * @return
     */
    public String toString() {
        return "VehicleEO contains: [vehicleID: " + this.vehicleID +
            " engineNumber: " + this.engineNumber + " chassisNumber: " +
            this.chassisNumber + " vehicleType: " + this.vehicleType +
            " vehicleColor: " +
            this.vehicleColor + " fuelUsed: " + this.fuelUsed +
            " manufactureDate: " + this.manufacturDate +
            " manufacturerName: " + this.manufacturerName + " modelNumber: " +
            this.variant + "]";
    }
}
