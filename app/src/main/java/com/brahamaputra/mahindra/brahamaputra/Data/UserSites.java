package com.brahamaputra.mahindra.brahamaputra.Data;


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

    @SerializedName("SiteType")
    private String SiteType;

    @SerializedName("TowerType")
    private String TowerType;

    @SerializedName("Latitude")
    private String Latitude;

    @SerializedName("Longitude")
    private String Longitude;

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