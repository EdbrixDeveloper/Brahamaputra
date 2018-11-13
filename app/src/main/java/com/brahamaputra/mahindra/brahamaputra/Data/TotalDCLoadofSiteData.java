package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

public class TotalDCLoadofSiteData
{

    @SerializedName("totalDcLoadOfSite")
    private String totalDcLoadOfSite;

    @SerializedName("isSubmited")
    private Boolean isSubmited;

    public TotalDCLoadofSiteData() {
        this.totalDcLoadOfSite = "";
        this.isSubmited=false;
    }

    public TotalDCLoadofSiteData(String totalDcLoadOfSite) {
        this.totalDcLoadOfSite = totalDcLoadOfSite;
        this.isSubmited=true;
    }

    public String getTotalDcLoadOfSite() {
        return totalDcLoadOfSite;
    }

    public void setTotalDcLoadOfSite(String totalDcLoadOfSite) {
        this.totalDcLoadOfSite = totalDcLoadOfSite;
    }

    public Boolean getSubmited() {
        return isSubmited;
    }

    public void setSubmited(Boolean submited) {
        isSubmited = submited;
    }
}
