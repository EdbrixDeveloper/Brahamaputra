package com.brahamaputra.mahindra.brahamaputra.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DiselRequestTicketList {

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("diselRequesttTicketNo")
    @Expose
    private String diselRequesttTicketNo;


    @SerializedName("SiteDBId")
    @Expose
    private String siteDBId;
    @SerializedName("SiteId")
    @Expose
    private String siteId;
    @SerializedName("SiteName")
    @Expose
    private String siteName;
    @SerializedName("SiteAddress")
    @Expose
    private String siteAddress;
    @SerializedName("SiteType")
    @Expose
    private String siteType;
    @SerializedName("SiteLatitude")
    private String Latitude;

    @SerializedName("SiteLongitude")
    private String Longitude;


    @SerializedName("ChildCardNumber")
    @Expose
    private String childCardNumber;
    @SerializedName("ApprovedQuantity")
    @Expose
    private String approvedQuantity;

    @SerializedName("SiteBillingMonth")
    @Expose
    private String SiteBillingMonth;
    @SerializedName("SiteIpAddress")
    @Expose
    private String SiteIpAddress;
    @SerializedName("SitePort")
    @Expose
    private String SitePort;
    @SerializedName("SiteImeiNumber")
    @Expose
    private String SiteImeiNumber;

    @SerializedName("DGMake")
    @Expose
    private String DGMake;
    @SerializedName("DGCapacity")
    @Expose
    private String DGCapacity;

    @SerializedName("RemainingQty")
    @Expose
    private String RemainingQty;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDiselRequesttTicketNo() {
        return diselRequesttTicketNo;
    }

    public void setDiselRequesttTicketNo(String diselRequesttTicketNo) {
        this.diselRequesttTicketNo = diselRequesttTicketNo;
    }

    public String getSiteDBId() {
        return siteDBId;
    }

    public void setSiteDBId(String siteDBId) {
        this.siteDBId = siteDBId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getChildCardNumber() {
        return childCardNumber;
    }

    public void setChildCardNumber(String childCardNumber) {
        this.childCardNumber = childCardNumber;
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

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public String getApprovedQuantity() {
        return approvedQuantity;
    }

    public void setApprovedQuantity(String approvedQuantity) {
        this.approvedQuantity = approvedQuantity;
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

    public String getSiteBillingMonth() {
        return SiteBillingMonth;
    }

    public void setSiteBillingMonth(String siteBillingMonth) {
        SiteBillingMonth = siteBillingMonth;
    }

    public String getSiteIpAddress() {
        return SiteIpAddress;
    }

    public void setSiteIpAddress(String siteIpAddress) {
        SiteIpAddress = siteIpAddress;
    }

    public String getSitePort() {
        return SitePort;
    }

    public void setSitePort(String sitePort) {
        SitePort = sitePort;
    }

    public String getSiteImeiNumber() {
        return SiteImeiNumber;
    }

    public void setSiteImeiNumber(String siteImeiNumber) {
        SiteImeiNumber = siteImeiNumber;
    }

    public String getDGMake() {
        return DGMake;
    }

    public void setDGMake(String DGMake) {
        this.DGMake = DGMake;
    }

    public String getDGCapacity() {
        return DGCapacity;
    }

    public void setDGCapacity(String DGCapacity) {
        this.DGCapacity = DGCapacity;
    }

    public String getRemainingQty() {
        return RemainingQty;
    }

    public void setRemainingQty(String remainingQty) {
        RemainingQty = remainingQty;
    }

}
