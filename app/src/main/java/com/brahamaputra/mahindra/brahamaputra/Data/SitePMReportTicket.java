
package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SitePMReportTicket {

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("SitePMLastTicketNo")
    @Expose
    private String sitePMLastTicketNo;
    @SerializedName("SitePMTicketLastDoneDate")
    @Expose
    private String sitePMTicketLastDoneDate;
    @SerializedName("SitePMTicketNextDueDate")
    @Expose
    private String sitePMTicketNextDueDate;
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

    public String getSitePMLastTicketNo() {
        return sitePMLastTicketNo;
    }

    public void setSitePMLastTicketNo(String sitePMLastTicketNo) {
        this.sitePMLastTicketNo = sitePMLastTicketNo;
    }

    public String getSitePMTicketLastDoneDate() {
        return sitePMTicketLastDoneDate;
    }

    public void setSitePMTicketLastDoneDate(String sitePMTicketLastDoneDate) {
        this.sitePMTicketLastDoneDate = sitePMTicketLastDoneDate;
    }

    public String getSitePMTicketNextDueDate() {
        return sitePMTicketNextDueDate;
    }

    public void setSitePMTicketNextDueDate(String sitePMTicketNextDueDate) {
        this.sitePMTicketNextDueDate = sitePMTicketNextDueDate;
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
