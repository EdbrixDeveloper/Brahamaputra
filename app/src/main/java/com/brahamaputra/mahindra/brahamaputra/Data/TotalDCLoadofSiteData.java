package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

public class TotalDCLoadofSiteData {

    @SerializedName("totalDcLoadOfSite")
    private String totalDcLoadOfSite;

    @SerializedName("isSubmited")
    //private Boolean isSubmited;
    private int isSubmited;

    public TotalDCLoadofSiteData() {
        this.totalDcLoadOfSite = "";
        this.isSubmited = 0;
    }

    public TotalDCLoadofSiteData(String totalDcLoadOfSite) {
        this.totalDcLoadOfSite = totalDcLoadOfSite;
        //this.isSubmited=true;//007
        this.isSubmited = 1;
        if (!this.totalDcLoadOfSite.isEmpty()) {
            this.isSubmited = 2;
        } /*else {
            this.isSubmited = 1;
        }*/
    }

    public String getTotalDcLoadOfSite() {
        return totalDcLoadOfSite;
    }

    public void setTotalDcLoadOfSite(String totalDcLoadOfSite) {
        this.totalDcLoadOfSite = totalDcLoadOfSite;
    }

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int submited) {
        isSubmited = submited;
    }
}
