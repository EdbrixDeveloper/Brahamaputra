package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AcPMReportTicket {
    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("AcPMLastTicketNo")
    @Expose
    private String acPMLastTicketNo;
    @SerializedName("AcPMTicketLastDoneDate")
    @Expose
    private String acPMTicketLastDoneDate;
    @SerializedName("AcPMTicketNextDueDate")
    @Expose
    private String acPMTicketNextDueDate;
    @SerializedName("SiteId")
    @Expose
    private String siteId;
    @SerializedName("SiteName")
    @Expose
    private String siteName;
    @SerializedName("SiteSSA")
    @Expose
    private String siteSSA;
    @SerializedName("SiteAddress")
    @Expose
    private String siteAddress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAcPMLastTicketNo() {
        return acPMLastTicketNo;
    }

    public void setAcPMLastTicketNo(String acPMLastTicketNo) {
        this.acPMLastTicketNo = acPMLastTicketNo;
    }

    public String getAcPMTicketLastDoneDate() {
        return acPMTicketLastDoneDate;
    }

    public void setAcPMTicketLastDoneDate(String acPMTicketLastDoneDate) {
        this.acPMTicketLastDoneDate = acPMTicketLastDoneDate;
    }

    public String getAcPMTicketNextDueDate() {
        return acPMTicketNextDueDate;
    }

    public void setAcPMTicketNextDueDate(String acPMTicketNextDueDate) {
        this.acPMTicketNextDueDate = acPMTicketNextDueDate;
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

    public String getSiteSSA() {
        return siteSSA;
    }

    public void setSiteSSA(String siteSSA) {
        this.siteSSA = siteSSA;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

}
