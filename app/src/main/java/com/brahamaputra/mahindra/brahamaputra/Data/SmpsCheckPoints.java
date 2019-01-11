
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SmpsCheckPoints implements Serializable
{

    @SerializedName("noOfSmpsAvailableAtSite")
    @Expose
    private String noOfSmpsAvailableAtSite;
    @SerializedName("smpsCheckPointsData")
    @Expose
    private List<SmpsCheckPointsDatum> smpsCheckPointsData = null;
    private final static long serialVersionUID = -2356912691505734753L;

    public String getNoOfSmpsAvailableAtSite() {
        return noOfSmpsAvailableAtSite;
    }

    public void setNoOfSmpsAvailableAtSite(String noOfSmpsAvailableAtSite) {
        this.noOfSmpsAvailableAtSite = noOfSmpsAvailableAtSite;
    }

    public List<SmpsCheckPointsDatum> getSmpsCheckPointsData() {
        return smpsCheckPointsData;
    }

    public void setSmpsCheckPointsData(List<SmpsCheckPointsDatum> smpsCheckPointsData) {
        this.smpsCheckPointsData = smpsCheckPointsData;
    }

}
