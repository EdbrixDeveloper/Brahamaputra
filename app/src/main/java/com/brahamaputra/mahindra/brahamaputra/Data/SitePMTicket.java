package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SitePMTicket {

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("SitePMTicketNo")
    @Expose
    private String sitePMTicketNo;
    @SerializedName("SitePMTicketDate")
    @Expose
    private String sitePMTicketDate;
    @SerializedName("SitePMScheduledDate")
    @Expose
    private String sitePMScheduledDate;
    @SerializedName("SitepmExecutionDate")
    @Expose
    private String sitepmExecutionDate;
    @SerializedName("SiteId")
    @Expose
    private String siteId;
    @SerializedName("SiteName")
    @Expose
    private String siteName;
    @SerializedName("SiteAddress")
    @Expose
    private String siteAddress;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("SiteType")
    @Expose
    private String siteType;
    @SerializedName("StateName")
    @Expose
    private String stateName;
    @SerializedName("CustomerName")
    @Expose
    private String customerName;
    @SerializedName("CircleName")
    @Expose
    private String circleName;
    @SerializedName("SSAName")
    @Expose
    private String sSAName;
    @SerializedName("SourceOfPower")
    @Expose
    private String sourceOfPower;
    /*@SerializedName("BatteryTypes")
    @Expose
    private List<Object> batteryTypes = null;*/
    @SerializedName("BatteryTypes")
    @Expose
    private List<BatteryType> batteryTypes = null;

    @SerializedName("SiteBoundaryStatus")
    @Expose
    private String siteBoundaryStatus;
    @SerializedName("NoOfACprovided")
    @Expose
    private String noOfACprovided;
    @SerializedName("ServoStabilizerWorkingStatus")
    @Expose
    private String servoStabilizerWorkingStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSitePMTicketNo() {
        return sitePMTicketNo;
    }

    public void setSitePMTicketNo(String sitePMTicketNo) {
        this.sitePMTicketNo = sitePMTicketNo;
    }

    public String getSitePMTicketDate() {
        return sitePMTicketDate;
    }

    public void setSitePMTicketDate(String sitePMTicketDate) {
        this.sitePMTicketDate = sitePMTicketDate;
    }

    public String getSitePMScheduledDate() {
        return sitePMScheduledDate;
    }

    public void setSitePMScheduledDate(String sitePMScheduledDate) {
        this.sitePMScheduledDate = sitePMScheduledDate;
    }

    public String getSitepmExecutionDate() {
        return sitepmExecutionDate;
    }

    public void setSitepmExecutionDate(String sitepmExecutionDate) {
        this.sitepmExecutionDate = sitepmExecutionDate;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    public String getSSAName() {
        return sSAName;
    }

    public void setSSAName(String sSAName) {
        this.sSAName = sSAName;
    }

    public String getSourceOfPower() {
        return sourceOfPower;
    }

    public void setSourceOfPower(String sourceOfPower) {
        this.sourceOfPower = sourceOfPower;
    }

    public List<BatteryType> getBatteryTypes() {
        return batteryTypes;
    }

    public void setBatteryTypes(List<BatteryType> batteryTypes) {
        this.batteryTypes = batteryTypes;
    }

    public String getSiteBoundaryStatus() {
        return siteBoundaryStatus;
    }

    public void setSiteBoundaryStatus(String siteBoundaryStatus) {
        this.siteBoundaryStatus = siteBoundaryStatus;
    }

    public String getNoOfACprovided() {
        return noOfACprovided;
    }

    public void setNoOfACprovided(String noOfACprovided) {
        this.noOfACprovided = noOfACprovided;
    }

    public String getServoStabilizerWorkingStatus() {
        return servoStabilizerWorkingStatus;
    }

    public void setServoStabilizerWorkingStatus(String servoStabilizerWorkingStatus) {
        this.servoStabilizerWorkingStatus = servoStabilizerWorkingStatus;
    }

}
