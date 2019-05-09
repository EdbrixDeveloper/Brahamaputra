package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AcPMReportSummary {
    @SerializedName("TotalSites")
    @Expose
    private String totalSites;
    @SerializedName("DoneSites")
    @Expose
    private String doneSites;
    @SerializedName("PendingSites")
    @Expose
    private String pendingSites;
    @SerializedName("TotalSitePm")
    @Expose
    private String totalSitePm;

    public String getTotalSites() {
        return totalSites;
    }

    public void setTotalSites(String totalSites) {
        this.totalSites = totalSites;
    }

    public String getDoneSites() {
        return doneSites;
    }

    public void setDoneSites(String doneSites) {
        this.doneSites = doneSites;
    }

    public String getPendingSites() {
        return pendingSites;
    }

    public void setPendingSites(String pendingSites) {
        this.pendingSites = pendingSites;
    }

    public String getTotalSitePm() {
        return totalSitePm;
    }

    public void setTotalSitePm(String totalSitePm) {
        this.totalSitePm = totalSitePm;
    }
}
