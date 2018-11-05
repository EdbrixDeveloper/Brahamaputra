package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

public class TotalDCLoadofSiteData
{

    @SerializedName("totalDcLoadOfSite")
    private String totalDcLoadOfSite;

    public TotalDCLoadofSiteData() {
    }

    public TotalDCLoadofSiteData(String totalDcLoadOfSite) {
        this.totalDcLoadOfSite = totalDcLoadOfSite;
    }

    public String getTotalDcLoadOfSite() {
        return totalDcLoadOfSite;
    }

    public void setTotalDcLoadOfSite(String totalDcLoadOfSite) {
        this.totalDcLoadOfSite = totalDcLoadOfSite;
    }


}
