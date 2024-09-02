package tms.persistence.entity;

import java.sql.Date;

public class VehicleEO {

    private int vehicleID;
    private String engineNumber;
    private String chassisNumber;
    private String vehicleType;
    private String vehicleBrand;
    private String vehicleColor;
    private String fuelUsed;
    private Date manufacturDate;
    private String manufacturerName;
    private String modelNo;

    public VehicleEO() {

    }

    public VehicleEO(int vehicleID, String engineNumber, String chassisNumber,
                     String vehicleType, String vehicleBrand,
                     String vehicleColor, String fuelUsed, Date manufacturDate,
                     String manufacturerName, String modelNo) {
        super();
        this.vehicleID = vehicleID;
        this.engineNumber = engineNumber;
        this.chassisNumber = chassisNumber;
        this.vehicleType = vehicleType;
        this.vehicleBrand = vehicleBrand;
        this.vehicleColor = vehicleColor;
        this.fuelUsed = fuelUsed;
        this.manufacturDate = manufacturDate;
        this.manufacturerName = manufacturerName;
        this.modelNo = modelNo;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setFuelUsed(String fuelUsed) {
        this.fuelUsed = fuelUsed;
    }

    public String getFuelUsed() {
        return fuelUsed;
    }

    public void setManufacturDate(Date manufacturDate) {
        this.manufacturDate = manufacturDate;
    }

    public Date getManufacturDate() {
        return manufacturDate;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public String getModelNo() {
        return modelNo;
    }

    public String toString() {
        return "VehicleEO contains: [vehicleID: " + this.vehicleID +
            " engineNumber: " + this.engineNumber + " chassisNumber: " +
            this.chassisNumber + " vehicleType: " + this.vehicleType +
            " vehicleBrand: " + this.vehicleBrand + " vehicleColor: " +
            this.vehicleColor + " fuelUsed: " + this.fuelUsed +
            " manufactureDate: " + this.manufacturDate +
            " manufacturerName: " + this.manufacturerName + " modelNumber: " +
            this.modelNo + "]";
    }
}
