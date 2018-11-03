
package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HotoTicket {

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("hotoTicketNo")
    @Expose
    private String hotoTicketNo;
    @SerializedName("hotoTicketDate")
    @Expose
    private String hotoTicketDate;
    @SerializedName("siteId")
    @Expose
    private String siteId;
    @SerializedName("siteName")
    @Expose
    private String siteName;
    @SerializedName("siteAddress")
    @Expose
    private String siteAddress;
    @SerializedName("status")
    @Expose
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHotoTicketNo() {
        return hotoTicketNo;
    }

    public void setHotoTicketNo(String hotoTicketNo) {
        this.hotoTicketNo = hotoTicketNo;
    }

    public String getHotoTicketDate() {
        return hotoTicketDate;
    }

    public void setHotoTicketDate(String hotoTicketDate) {
        this.hotoTicketDate = hotoTicketDate;
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

    public HotoTicket(String id, String hotoTicketNo, String hotoTicketDate, String siteId, String siteName, String siteAddress, String status) {
        this.id = id;
        this.hotoTicketNo = hotoTicketNo;
        this.hotoTicketDate = hotoTicketDate;
        this.siteId = siteId;
        this.siteName = siteName;
        this.siteAddress = siteAddress;
        this.status = status;
    }
}
