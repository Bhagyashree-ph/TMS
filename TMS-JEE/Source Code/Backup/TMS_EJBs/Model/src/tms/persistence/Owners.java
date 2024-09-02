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
  @NamedQuery(name = "Owners.findAll", query = "select o from Owners o")
})
public class Owners implements Serializable {
    @Column(nullable = false, length = 200)
    private String address;
    @Column(nullable = false)
    private Timestamp dateofbirth;
    @Column(name="FIRST_NAME", nullable = false, length = 20)
    private String firstName;
    @Column(length = 6)
    private String gender;
    @Column(name="ID_TYPE", nullable = false, length = 20)
    private String idType;
    @Column(name="LAST_NAME", length = 20)
    private String lastName;
    @Column(nullable = false, length = 20)
    private String occupation;
    @Id
    @Column(name="OWNER_ID", nullable = false, length = 12)
    private String ownerId;
    @Column(name="PHONE_NUMBER", nullable = false, length = 20)
    private String phoneNumber;
    @Column(nullable = false)
    private Long pincode;
    //@OneToMany(mappedBy = "owners")
    //private List<Registrations> registrationsList;

    public Owners() {
    }

    public Owners(String address, Timestamp dateofbirth, String firstName,
                  String gender, String idType, String lastName,
                  String occupation, String ownerId, String phoneNumber,
                  Long pincode) {
        this.address = address;
        this.dateofbirth = dateofbirth;
        this.firstName = firstName;
        this.gender = gender;
        this.idType = idType;
        this.lastName = lastName;
        this.occupation = occupation;
        this.ownerId = ownerId;
        this.phoneNumber = phoneNumber;
        this.pincode = pincode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Timestamp dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getPincode() {
        return pincode;
    }

    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }

    /*public List<Registrations> getRegistrationsList() {
        return registrationsList;
    }

    public void setRegistrationsList(List<Registrations> registrationsList) {
        this.registrationsList = registrationsList;
    }

    public Registrations addRegistrations(Registrations registrations) {
        getRegistrationsList().add(registrations);
        registrations.setOwners(this);
        return registrations;
    }

    public Registrations removeRegistrations(Registrations registrations) {
        getRegistrationsList().remove(registrations);
        registrations.setOwners(null);
        return registrations;
    }*/
    
    @Override
    public String toString() {
        return "Owners [address=" + address + ", dateofbirth=" + dateofbirth + ", firstName=" + firstName + ", gender="
                + gender + ", idType=" + idType + ", lastName=" + lastName + ", occupation=" + occupation + ", ownerId="
                + ownerId + ", phoneNumber=" + phoneNumber + ", pincode=" + pincode + "]";
    }
}
