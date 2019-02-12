package com.brahamaputra.mahindra.brahamaputra.Data;
import com.google.gson.annotations.SerializedName;

public class ExternalTenantsPersonalDetailsData {
   /* @SerializedName("totalNumberofTanents")
    private String totalNumberofTanents;*/

    @SerializedName("nameofTenant")
    private String nameofTenant;

    @SerializedName("typeofTenant")
    private String typeofTenant;

    @SerializedName("positionattheTower")
    private String positionattheTower;

    @SerializedName("dateofstartofTenancy")
    private String dateofstartofTenancy;

    @SerializedName("dateofstartofRadiation")
    private String dateofstartofRadiation;

    @SerializedName("nameofContactPerson")
    private String nameofContactPerson;

    @SerializedName("addressofContactPerson")
    private String addressofContactPerson;

    @SerializedName("contactPersonMobile")
    private String contactPersonMobile;

    @SerializedName("contactPersonLandline")
    private String contactPersonLandline;

    @SerializedName("rentalValue")
    private String rentalValue;

    public String getRentalValue() {
        return rentalValue;
    }

    public void setRentalValue(String rentalValue) {
        this.rentalValue = rentalValue;
    }
    /*@SerializedName("isSubmited")
    private Boolean isSubmited;*/

   /* public String getTotalNumberofTanents() {
        return totalNumberofTanents;
    }

    public void setTotalNumberofTanents(String totalNumberofTanents) {
        this.totalNumberofTanents = totalNumberofTanents;
    }*/

    public ExternalTenantsPersonalDetailsData() {
        //  this.totalNumberofTanents = "";
        this.nameofTenant = "";
        this.typeofTenant = "";
        this.positionattheTower = "";
        this.dateofstartofTenancy = "";
        this.dateofstartofRadiation = "";
        this.nameofContactPerson = "";
        this.addressofContactPerson = "";
        this.contactPersonMobile = "";
        this.contactPersonLandline = "";
        // this.isSubmited=false;
        this.rentalValue = "";
    }

    public ExternalTenantsPersonalDetailsData(String nameofTenant,String rentalValue, String typeofTenant, String positionattheTower, String dateofstartofTenancy, String dateofstartofRadiation, String nameofContactPerson, String addressofContactPerson, String contactPersonMobile, String contactPersonLandline) {
        //this.totalNumberofTanents = totalNumberofTanents;
        this.nameofTenant = nameofTenant;
        this.typeofTenant = typeofTenant;
        this.positionattheTower = positionattheTower;
        this.dateofstartofTenancy = dateofstartofTenancy;
        this.dateofstartofRadiation = dateofstartofRadiation;
        this.nameofContactPerson = nameofContactPerson;
        this.addressofContactPerson = addressofContactPerson;
        this.contactPersonMobile = contactPersonMobile;
        this.contactPersonLandline = contactPersonLandline;
        this.rentalValue = rentalValue;
        // this.isSubmited=true;
    }

    public String getNameofTenant() {
        return nameofTenant;
    }

    public void setNameofTenant(String nameofTenant) {
        this.nameofTenant = nameofTenant;
    }

    public String getTypeofTenant() {
        return typeofTenant;
    }

    public void setTypeofTenant(String typeofTenant) {
        this.typeofTenant = typeofTenant;
    }

    public String getPositionattheTower() {
        return positionattheTower;
    }

    public void setPositionattheTower(String positionattheTower) {
        this.positionattheTower = positionattheTower;
    }

    public String getDateofstartofTenancy() {
        return dateofstartofTenancy;
    }

    public void setDateofstartofTenancy(String dateofstartofTenancy) {
        this.dateofstartofTenancy = dateofstartofTenancy;
    }

    public String getDateofstartofRadiation() {
        return dateofstartofRadiation;
    }

    public void setDateofstartofRadiation(String dateofstartofRadiation) {
        this.dateofstartofRadiation = dateofstartofRadiation;
    }

    public String getNameofContactPerson() {
        return nameofContactPerson;
    }

    public void setNameofContactPerson(String nameofContactPerson) {
        this.nameofContactPerson = nameofContactPerson;
    }

    public String getAddressofContactPerson() {
        return addressofContactPerson;
    }

    public void setAddressofContactPerson(String addressofContactPerson) {
        this.addressofContactPerson = addressofContactPerson;
    }

    public String getContactPersonMobile() {
        return contactPersonMobile;
    }

    public void setContactPersonMobile(String contactPersonMobile) {
        this.contactPersonMobile = contactPersonMobile;
    }

    public String getContactPersonLandline() {
        return contactPersonLandline;
    }

    public void setContactPersonLandline(String contactPersonLandline) {
        this.contactPersonLandline = contactPersonLandline;
    }

    /*public Boolean getSubmited() {
        return isSubmited;
    }

    public void setSubmited(Boolean submited) {
        isSubmited = submited;
    }*/
}
