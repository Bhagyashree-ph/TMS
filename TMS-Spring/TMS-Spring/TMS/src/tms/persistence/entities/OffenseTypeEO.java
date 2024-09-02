package tms.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author bhagya.shree
 *
 */
@Entity
@Table(name = "OFFENSE_TYPES")
//@NamedQuery(name = "OffenseTypes.findAll", query = "select oft from OffenseTypeEO oft")
public class OffenseTypeEO {

	@Id
	@Column(name = "OFFENSE_ID")
	private String offenseId;

	@Column(name = "OFFENSE_NAME")
	private String offenseName;

	@Column(name = "VEHICLE_TYPE")
	private String vehicleType;

	@Column
	private Double penalty;

	public OffenseTypeEO() {

	}

	/**
	 * @param offenseName
	 * @param vehicleType
	 * @param penalty
	 */
	public OffenseTypeEO(String offenseName, String vehicleType, Double penalty) {
		super();
		this.offenseId = "OF001";
		this.offenseName = offenseName;
		this.vehicleType = vehicleType;
		this.penalty = penalty;
	}

	/**
	 * @return
	 */
	public String getOffenseId() {
		return offenseId;
	}

	/**
	 * @return
	 */
	public String getOffenseName() {
		return offenseName;
	}

	/**
	 * @param offenseName
	 */
	public void setOffenseName(String offenseName) {
		this.offenseName = offenseName;
	}

	/**
	 * @return
	 */
	public String getVehicleType() {
		return vehicleType;
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
	public Double getPenalty() {
		return penalty;
	}

	/**
	 * @param penalty
	 */
	public void setPenalty(Double penalty) {
		this.penalty = penalty;
	}

	/**
	 * @return
	 */
	@Override
	public String toString() {
		return "OffenseTypeEO [offenseId=" + offenseId + ", offenseName=" + offenseName + ", vehicleType=" + vehicleType
				+ ", penalty=" + penalty + "]";
	}
}
