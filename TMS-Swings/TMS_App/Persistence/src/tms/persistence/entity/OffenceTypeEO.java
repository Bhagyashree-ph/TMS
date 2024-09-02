package tms.persistence.entity;

public class OffenceTypeEO {

    private String offenseID;
    private String offenseName;
    private String vehicleType;
    private int penalty;

    public OffenceTypeEO() {

    }

    public OffenceTypeEO(String offenseID, String offenseName,
                         String vehicleType, int penalty) {
        super();
        this.offenseID = offenseID;
        this.offenseName = offenseName;
        this.vehicleType = vehicleType;
        this.penalty = penalty;
    }

    public void setOffenseID(String offenseID) {
        this.offenseID = offenseID;
    }

    public String getOffenseID() {
        return offenseID;
    }

    public void setOffenseName(String offenseName) {
        this.offenseName = offenseName;
    }

    public String getOffenseName() {
        return offenseName;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public int getPenalty() {
        return penalty;
    }

    @Override
    public String toString() {
        return "OffenseTypeEO contains: [offenseID: " + this.offenseID +
            " offenseName: " + this.offenseName + " vehicleType: " +
            this.vehicleType + " penalty: " + this.penalty + "]";
    }
}
