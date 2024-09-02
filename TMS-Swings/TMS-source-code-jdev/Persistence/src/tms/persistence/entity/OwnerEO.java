package tms.persistence.entity;

import java.sql.*;

public class OwnerEO {

    private String ownerID;
    private String idType;
    private String fName;
    private String lName;
    private Date dob;
    private String gender;
    private String phoneNumber;
    private String address;
    private int pincode;
    private String occupation;

    public OwnerEO()
    {

    }

    public OwnerEO(String ownerID, String idType, String fName, String lName,
                   Date dob, String gender, String phoneNumber, String address,
                   int pincode, String occupation) {
        super();
        this.ownerID = ownerID;
        this.idType = idType;
        this.fName = fName;
        this.lName = lName;
        this.dob = dob;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.pincode = pincode;
        this.occupation = occupation;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdType() {
        return idType;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getFName() {
        return fName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getLName() {
        return lName;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getDob() {
        return dob;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public int getPincode() {
        return pincode;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getOccupation() {
        return occupation;
    }

    @Override
    public String toString() {
        return "OwnerEO contains: [ownerID: " + this.ownerID + " IDType: " +
            this.idType + " firstName: " + this.fName + " lastName: " +
            this.lName + " DateOfBirth: " + dob + " gender: " + this.gender +
            " phoneNumber: " + this.phoneNumber + " address: " + this.address +
            " pincode: " + this.pincode + " occupattion: " + this.occupation +
            "]";
    }
}
