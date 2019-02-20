package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SiteList {

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("SiteName")
    @Expose
    private String siteName;
    @SerializedName("SiteId")
    @Expose
    private String siteId;
    @SerializedName("SiteAddress")
    @Expose
    private String siteAddress;
    @SerializedName("SiteType")
    @Expose
    private String siteType;
    @SerializedName("TowerType")
    @Expose
    private String towerType;
    @SerializedName("EbOfficeName")
    @Expose
    private String ebOfficeName;

    @SerializedName("CircleId")
    private String CircleId;

    @SerializedName("CircleName")
    private String CircleName;

    @SerializedName("StateId")
    private String StateId;

    @SerializedName("StateName")
    private String StateName;

    @SerializedName("SsaId")
    private String SsaId;

    @SerializedName("SsaName")
    private String SsaName;


    //////

    @SerializedName("Latitude")
    private String Latitude;

    @SerializedName("Longitude")
    private String Longitude;

    @SerializedName("BillingMonth")
    private String BillingMonth;

    @SerializedName("IpAddress")
    private String IpAddress;

    @SerializedName("Port")
    private String Port;

    @SerializedName("ImeiNumber")
    private String ImeiNumber;

    @SerializedName("PetroCompanyName")
    private String PetroCompanyName;

    @SerializedName("ChildCardNumber")
    private String ChildCardNumber;

    @SerializedName("SourceOfPower")
    private String SourceOfPower;

    @SerializedName("LastDieselFillingDate")
    private String LastDieselFillingDate;

    @SerializedName("LastDieselStock")
    private String LastDieselStock;

    @SerializedName("LastDGHMR")
    private String LastDGHMR;

    @SerializedName("LastEBReading")
    private String LastEBReadingl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public String getTowerType() {
        return towerType;
    }

    public void setTowerType(String towerType) {
        this.towerType = towerType;
    }

    public String getEbOfficeName() {
        return ebOfficeName;
    }

    public void setEbOfficeName(String ebOfficeName) {
        this.ebOfficeName = ebOfficeName;
    }

    ////////


    public String getCircleId() {
        return CircleId;
    }

    public void setCircleId(String CircleId) {
        this.CircleId = CircleId;
    }

    public String getCircleName() {
        return CircleName;
    }

    public void setCircleName(String CircleName) {
        this.CircleName = CircleName;
    }

    public String getStateId() {
        return StateId;
    }

    public void setStateId(String StateId) {
        this.StateId = StateId;
    }

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String StateName) {
        this.StateName = StateName;
    }

    public String getSsaId() {
        return SsaId;
    }

    public void setSsaId(String SsaId) {
        this.SsaId = SsaId;
    }

    public String getSsaName() {
        return SsaName;
    }

    public void setSsaName(String SsaName) {
        this.SsaName = SsaName;
    }



    ///////////////////////////////











    public String getBillingMonth() {
        return BillingMonth;
    }

    public void setBillingMonth(String billingMonth) {
        BillingMonth = billingMonth;
    }


    public String getIpAddress() {
        return IpAddress;
    }

    public void setIpAddress(String ipAddress) {
        IpAddress = ipAddress;
    }


    public String getPort() {
        return Port;
    }

    public void setPort(String port) {
        Port = port;
    }


    public String getImeiNumber() {
        return ImeiNumber;
    }

    public void setImeiNumber(String imeiNumber) {
        ImeiNumber = imeiNumber;
    }


    public String getPetroCompanyName() {
        return PetroCompanyName;
    }

    public void setPetroCompanyName(String petroCompanyName) {
        PetroCompanyName = petroCompanyName;
    }


    public String getChildCardNumber() {
        return ChildCardNumber;
    }

    public void setChildCardNumber(String childCardNumber) {
        ChildCardNumber = childCardNumber;
    }


    public String getSourceOfPower() {
        return SourceOfPower;
    }

    public void setSourceOfPower(String sourceOfPower) {
        SourceOfPower = sourceOfPower;
    }


    public String getLastDieselFillingDate() {
        return LastDieselFillingDate;
    }

    public void setLastDieselFillingDate(String lastDieselFillingDate) {
        LastDieselFillingDate = lastDieselFillingDate;
    }


    public String getLastDieselStock() {
        return LastDieselStock;
    }

    public void setLastDieselStock(String lastDieselStock) {
        LastDieselStock = lastDieselStock;
    }


    public String getLastDGHMR() {
        return LastDGHMR;
    }

    public void setLastDGHMR(String lastDGHMR) {
        LastDGHMR = lastDGHMR;
    }


    public String getLastEBReadingl() {
        return LastEBReadingl;
    }

    public void setLastEBReadingl(String lastEBReadingl) {
        LastEBReadingl = lastEBReadingl;
    }


    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

}
