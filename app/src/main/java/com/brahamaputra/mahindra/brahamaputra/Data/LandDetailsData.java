package com.brahamaputra.mahindra.brahamaputra.Data;
import com.google.gson.annotations.SerializedName;

public class LandDetailsData {

    @SerializedName("landType")
    private String landType;

    @SerializedName("landArea")
    private String landArea;

    @SerializedName("rentLeaseValue")
    private String rentLeaseValue;

    @SerializedName("bookValueOfLand")
    private String baseValueOfLand;

    public String getBaseValueOfLand() {
        return baseValueOfLand;
    }

    public void setBaseValueOfLand(String baseValueOfLand) {
        this.baseValueOfLand = baseValueOfLand;
    }

    @SerializedName("rentLeaseValueInWords")
    private String rentLeaseValueInWords;

    @SerializedName("landOwnerName")
    private String landOwnerName;

    @SerializedName("landOwnerMob")
    private String landOwnerMob;

    @SerializedName("landLayout")
    private String landLayout;

    @SerializedName("landAgreementCopy")
    private String landAgreementCopy;

    @SerializedName("landAgreementValidity")
    private String landAgreementValidity;

    @SerializedName("isSubmited")
    //private Boolean isSubmited;
    private int isSubmited;

    private String landLayoutFileName;

    //region Region Of Constructors
    public LandDetailsData() {
        this.landType = "";
        this.landArea = "";
        this.rentLeaseValue = "";
        this.rentLeaseValueInWords = "";
        this.landOwnerName = "";
        this.landOwnerMob = "";
        this.landLayout = "";
        this.landAgreementCopy = "";
        this.landAgreementValidity = "";
        this.landLayoutFileName = "";
        this.rentLeaseValue = "";
        this.isSubmited = 0;
    }

    public LandDetailsData(String landType, String landArea, String rentLeaseValue,String baseValueOfLand, String rentLeaseValueInWords, String landOwnerName, String landOwnerMob, String landLayout, String landAgreementCopy, String landAgreementValidity, String landLayoutFileName) {
        this.landType = landType;
        this.landArea = landArea;
        this.rentLeaseValue = rentLeaseValue;
        this.baseValueOfLand = baseValueOfLand;
        this.rentLeaseValueInWords = rentLeaseValueInWords;
        this.landOwnerName = landOwnerName;
        this.landOwnerMob = landOwnerMob;
        this.landLayout = landLayout;
        this.landAgreementCopy = landAgreementCopy;
        this.landAgreementValidity = landAgreementValidity;
        this.landLayoutFileName = landLayoutFileName;

        //this.isSubmited=true;//007
        if (!this.landType.isEmpty() && !this.landArea.isEmpty() && !this.landAgreementCopy.isEmpty()) {
            this.isSubmited = 2;
        } else {
            this.isSubmited = 1;
        }
    }
    //endregion

    //region Region Of Getter() Setter() Properties()
    public String getLandType() {
        return landType;
    }

    public void setLandType(String landType) {
        this.landType = landType;
    }

    public String getLandArea() {
        return landArea;
    }

    public void setLandArea(String landArea) {
        this.landArea = landArea;
    }

    public String getRentLeaseValue() {
        return rentLeaseValue;
    }

    public void setRentLeaseValue(String rentLeaseValue) {
        this.rentLeaseValue = rentLeaseValue;
    }

    public String getRentLeaseValueInWords() {
        return rentLeaseValueInWords;
    }

    public void setRentLeaseValueInWords(String rentLeaseValueInWords) {
        this.rentLeaseValueInWords = rentLeaseValueInWords;
    }

    public String getLandOwnerName() {
        return landOwnerName;
    }

    public void setLandOwnerName(String landOwnerName) {
        this.landOwnerName = landOwnerName;
    }

    public String getLandOwnerMob() {
        return landOwnerMob;
    }

    public void setLandOwnerMob(String landOwnerMob) {
        this.landOwnerMob = landOwnerMob;
    }

    public String getLandLayout() {
        return landLayout;
    }

    public void setLandLayout(String landLayout) {
        this.landLayout = landLayout;
    }

    public String getLandAgreementCopy() {
        return landAgreementCopy;
    }

    public void setLandAgreementCopy(String landAgreementCopy) {
        this.landAgreementCopy = landAgreementCopy;
    }

    public String getLandAgreementValidity() {
        return landAgreementValidity;
    }

    public void setLandAgreementValidity(String landAgreementValidity) {
        this.landAgreementValidity = landAgreementValidity;
    }

    public String getLandLayoutFileName() {
        return landLayoutFileName;
    }

    public void setLandLayoutFileName(String landLayoutFileName) {
        this.landLayoutFileName = landLayoutFileName;
    }

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int submited) {
        isSubmited = submited;
    }
    //endregion
}
