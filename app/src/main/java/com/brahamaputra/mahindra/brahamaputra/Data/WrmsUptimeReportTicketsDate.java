package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WrmsUptimeReportTicketsDate {
    @SerializedName("SiteId")
    @Expose
    private String siteId;
    @SerializedName("SiteName")
    @Expose
    private String siteName;
    @SerializedName("SiteSSA")
    @Expose
    private String siteSSA;
    @SerializedName("SiteUptime")
    @Expose
    private String siteUptime;
    @SerializedName("SiteDeviation")
    @Expose
    private String siteDeviation;
    @SerializedName("NoOfEvents")
    @Expose
    private String noOfEvents;
    @SerializedName("TotalOutageMinutes")
    @Expose
    private String totalOutageMinutes;
    @SerializedName("WrmsUptimeReportTickets")
    @Expose
    private List<WrmsUptimeReportTicket> wrmsUptimeReportTickets = null;

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

    public String getSiteUptime() {
        return siteUptime;
    }

    public void setSiteUptime(String siteUptime) {
        this.siteUptime = siteUptime;
    }

    public String getSiteDeviation() {
        return siteDeviation;
    }

    public void setSiteDeviation(String siteDeviation) {
        this.siteDeviation = siteDeviation;
    }

    public String getNoOfEvents() {
        return noOfEvents;
    }

    public void setNoOfEvents(String noOfEvents) {
        this.noOfEvents = noOfEvents;
    }

    public String getTotalOutageMinutes() {
        return totalOutageMinutes;
    }

    public void setTotalOutageMinutes(String totalOutageMinutes) {
        this.totalOutageMinutes = totalOutageMinutes;
    }

    public List<WrmsUptimeReportTicket> getWrmsUptimeReportTickets() {
        return wrmsUptimeReportTickets;
    }

    public void setWrmsUptimeReportTickets(List<WrmsUptimeReportTicket> wrmsUptimeReportTickets) {
        this.wrmsUptimeReportTickets = wrmsUptimeReportTickets;
    }
}
