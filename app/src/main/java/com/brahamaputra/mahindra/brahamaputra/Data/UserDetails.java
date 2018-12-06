
package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserDetails {

    @SerializedName("Id")
    @Expose
    private String id;

    @SerializedName("FirstName")
    @Expose
    private String firstName;

    @SerializedName("LastName")
    @Expose
    private String lastName;

    @SerializedName("Username")
    @Expose
    private String username;

    @SerializedName("Email")
    @Expose
    private String Email;

    @SerializedName("Designation")
    @Expose
    private String Designation;

    @SerializedName("MobileNo")
    @Expose
    private String MobileNo;

    @SerializedName("ProfileImageUrl")
    @Expose
    private String ProfileImageUrl;


    @SerializedName("UserAdditionalDetails")
    @Expose
    private UserAdditionalDetails userAdditionalDetails;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getProfileImageUrl() {
        return ProfileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        ProfileImageUrl = profileImageUrl;
    }

    public UserAdditionalDetails getUserAdditionalDetails() {
        return userAdditionalDetails;
    }

    public void setUserAdditionalDetails(UserAdditionalDetails userAdditionalDetails) {
        this.userAdditionalDetails = userAdditionalDetails;
    }


}
