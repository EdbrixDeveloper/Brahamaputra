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
    private Object siteAddress;
    @SerializedName("SiteType")
    @Expose
    private String siteType;
    @SerializedName("TowerType")
    @Expose
    private String towerType;
    @SerializedName("EbOfficeName")
    @Expose
    private String ebOfficeName;

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

    public Object getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(Object siteAddress) {
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

}
