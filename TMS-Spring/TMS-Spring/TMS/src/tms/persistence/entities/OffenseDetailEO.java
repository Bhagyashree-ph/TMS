/**
 *
 */
package tms.persistence.entities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.sql.Timestamp;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author bhagya.shree
 *
 */
@Entity
@Table(name = "OFFENSE_DETAILS")
@NamedQuery(name = "OffenseDetails.findAll", query = "select ofd from OffenseDetailEO ofd")
public class OffenseDetailEO {

	@Id
	@Column(name = "OFFENSE_DETAIL_ID")
	private String offenseDetailId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy, hh:mm:ss a")
	@Column(name = "OFFENSE_DATE_TIME")
	private Timestamp dateTime;

	@Column
	private String place;

	@Column(name = "IMAGE")
	private byte[] img;

	@JoinColumn(name = "OFFENSE_ID", referencedColumnName = "OFFENSE_ID")
	@ManyToOne
	private OffenseTypeEO offense;

	@JoinColumn(name = "REGISTRATION_ID", referencedColumnName = "REGISTRATION_ID")
	@ManyToOne
	private RegistrationEO registration;

	@JoinColumn(name = "RECORDED_BY", referencedColumnName = "USER_ID")
	@ManyToOne
	private UsersEO user;

	@Column(name = "PENALTY_STATUS", nullable = false)
	private String penaltyStatus;

	public OffenseDetailEO() {

	}

	/**
	 * @param dateTime
	 * @param place
	 * @param img
	 * @param offense
	 * @param registration
	 * @param user
	 * @param penaltyStatus
	 */

	public OffenseDetailEO(Timestamp dateTime, String place, byte[] img, OffenseTypeEO offense,
			RegistrationEO registration, UsersEO user, String penaltyStatus) {
		super();
		this.dateTime = dateTime;
		this.place = place;
		this.img = img;
		this.offense = offense;
		this.registration = registration;
		this.user = user;
		this.penaltyStatus = penaltyStatus;
	}

	/**
	 * @return
	 */
	public String getOffenseDetailId() {
		return offenseDetailId;
	}
	public void setOffenseDetailId(String ofdId) {
		this.offenseDetailId = ofdId;
	}

	/**
	 * @return
	 */
	public Timestamp getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime
	 */
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * @return
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @param place
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * @return
	 */
	public byte[] getImg() {
		return img;
	}

	/**
	 * @param img
	 */
	public void setImg(byte[] img) {
		this.img = img;
	}

	/**
	 * @param path
	 */
	public void setImg(String path) {
		try {
			FileInputStream fp = new FileInputStream(path);
			img = new byte[fp.available()];
			fp.read(img);
		} catch (FileNotFoundException e) {
			System.out.println("Path not Found");
		} catch (IOException e) {
			System.out.println("IO Exception");
		}

	}

	/**
	 * 
	 * @return
	 */
	public OffenseTypeEO getOffense() {
		return offense;
	}

	/**
	 * 
	 * @param offense
	 */
	public void setOffense(OffenseTypeEO offense) {
		this.offense = offense;
	}

	/**
	 * 
	 * @return
	 */
	public RegistrationEO getRegistration() {
		return registration;
	}

	/**
	 * 
	 * @param registration
	 */
	public void setRegistration(RegistrationEO registration) {
		this.registration = registration;
	}

	/**
	 * 
	 * @return
	 */
	public UsersEO getUser() {
		return user;
	}

	/**
	 * 
	 * @param user
	 */
	public void setUser(UsersEO user) {
		this.user = user;
	}

	/**
	 * 
	 * @return
	 */
	public String getPenaltyStatus() {
		return penaltyStatus;
	}

	/**
	 * 
	 * @param penaltyStatus
	 */
	public void setPenaltyStatus(String penaltyStatus) {
		this.penaltyStatus = penaltyStatus;
	}

	/**
	 * @return details of the OffenseDetailEO
	 */
	@Override
	public String toString() {
		return "OffenseDetailEO [offenseDetailId=" + offenseDetailId + ", dateTime=" + dateTime + ", place=" + place
				+ ", img=" + Arrays.toString(img) + ", offense=" + offense + ", registration=" + registration
				+ ", user=" + user + ", penaltyStatus=" + penaltyStatus + "]";
	}
}
