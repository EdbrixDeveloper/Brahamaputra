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


    @SerializedName("ChildCardNumber")
    @Expose
    private String childCardNumber;
    @SerializedName("ApprovedQuantity")
    @Expose
    private String approvedQuantity;


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

}
