
package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DgCheckPointsParentData implements Serializable {

    @SerializedName("noOfDgAvailableAtSite")
    @Expose
    private String noOfDgAvailableAtSite;

    @SerializedName("dgCheckPointsData")
    @Expose
    private List<DgCheckPointsData> dgCheckPointsData;

    public DgCheckPointsParentData() {
        this.noOfDgAvailableAtSite = "";
        this.dgCheckPointsData = new ArrayList<>();
    }

    public DgCheckPointsParentData(String noOfDgAvailableAtSite, List<DgCheckPointsData> dgCheckPointsData) {
        this.noOfDgAvailableAtSite = noOfDgAvailableAtSite;
        this.dgCheckPointsData = dgCheckPointsData;
    }

    public String getNoOfDgAvailableAtSite() {
        return noOfDgAvailableAtSite;
    }

    public void setNoOfDgAvailableAtSite(String noOfDgAvailableAtSite) {
        this.noOfDgAvailableAtSite = noOfDgAvailableAtSite;
    }

    public List<DgCheckPointsData> getDgCheckPointsData() {
        return dgCheckPointsData;
    }

    public void setDgCheckPointsData(List<DgCheckPointsData> dgCheckPointsData) {
        this.dgCheckPointsData = dgCheckPointsData;
    }

}
