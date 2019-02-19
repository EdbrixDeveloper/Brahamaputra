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

}
