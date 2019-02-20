package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserSites {

    @SerializedName("Id")
    private String Id;

    @SerializedName("SiteId")
    private String SiteId;

    @SerializedName("SiteName")
    private String SiteName;

    @SerializedName("SiteAddress")
    private String SiteAddress;

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

    @SerializedName("SiteType")
    private String SiteType;

    @SerializedName("TowerType")
    private String TowerType;

    @SerializedName("Latitude")
    private String Latitude;

    @SerializedName("Longitude")
    private String Longitude;

///////////////////////////////////////

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

    @SerializedName("EbOfficeName")
    @Expose
    private String ebOfficeName;

//////////////////////////////////////

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

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getSiteId() {
        return SiteId;
    }

    public void setSiteId(String siteId) {
        SiteId = siteId;
    }

    public String getSiteName() {
        return SiteName;
    }

    public void setSiteName(String siteName) {
        SiteName = siteName;
    }

    public String getSiteAddress() {
        return SiteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        SiteAddress = siteAddress;
    }

    public String getSiteType() {
        return SiteType;
    }

    public void setSiteType(String siteType) {
        SiteType = siteType;
    }

    public String getTowerType() {
        return TowerType;
    }

    public void setTowerType(String towerType) {
        TowerType = towerType;
    }

    //////////////////////////

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

    public String getEbOfficeName() {
        return ebOfficeName;
    }

    public void setEbOfficeName(String ebOfficeName) {
        this.ebOfficeName = ebOfficeName;
    }

    /*public UserSites(String id, String siteId, String siteName, Object siteAddress, String siteType, String towerType) {
        Id = id;
        SiteId = siteId;
        SiteName = siteName;
        SiteAddress = siteAddress;
        SiteType = siteType;
        TowerType = towerType;
    }

    public UserSites() {
        Id = "";
        SiteId = "";
        SiteName = "";
        SiteAddress ="";
        SiteType = "";
        TowerType = "";
    }*/
}