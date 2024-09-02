package tms.persistence.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "OWNERS")
@NamedQueries({ @NamedQuery(name = "Owners.findAll", query = "select ownerRef from OwnerEO ownerRef") })
public class OwnerEO {

	@Id
	@Column(name = "OWNER_ID")
	private String ownerId;

	@Column(name = "ID_TYPE")
	private String idType;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "DATEOFBIRTH")
	private Date dateOfBirth;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "PINCODE")
	private Integer pincode;

	@Column(name = "OCCUPATION")
	private String occupation;

	public OwnerEO() {

	}

	/**
	 * @param ownerId
	 * @param idType
	 * @param firstName
	 * @param lastName
	 * @param dateOfBirth
	 * @param gender
	 * @param phoneNumber
	 * @param address
	 * @param pincode
	 * @param occupation
	 */
	public OwnerEO(String ownerId, String idType, String firstName, String lastName, Date dateOfBirth, String gender,
			String phoneNumber, String address, Integer pincode, String occupation) {
		super();
		this.ownerId = ownerId;
		this.idType = idType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.pincode = pincode;
		this.occupation = occupation;
	}

	/**
	 * @return
	 */
	public String getOwnerId() {
		return ownerId;
	}

	/**
	 * @param ownerId
	 */
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * @return
	 */
	public String getIdType() {
		return idType;
	}

	/**
	 * @param idType
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}

	/**
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return
	 */
	public Integer getPincode() {
		return pincode;
	}

	/**
	 * @param pincode
	 */
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	/**
	 * @return
	 */
	public String getOccupation() {
		return occupation;
	}

	/**
	 * @param occupation
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	/**
	 * @return
	 */
	@Override
	public String toString() {
		return "OwnerEO [ownerId=" + ownerId + ", idType=" + idType + ", firstName=" + firstName + ", lastName="
				+ lastName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + ", pincode=" + pincode + ", occupation=" + occupation + "]";
	}

}
