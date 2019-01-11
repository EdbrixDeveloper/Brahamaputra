
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PmsAmfPanelCheckPoints implements Serializable
{

    @SerializedName("noOfPmsAmfPiuAvailableAtSite")
    @Expose
    private String noOfPmsAmfPiuAvailableAtSite;
    @SerializedName("pmsAmfPanelCheckPointsData")
    @Expose
    private List<PmsAmfPanelCheckPointsDatum> pmsAmfPanelCheckPointsData = null;
    private final static long serialVersionUID = -6067841024671567130L;

    public String getNoOfPmsAmfPiuAvailableAtSite() {
        return noOfPmsAmfPiuAvailableAtSite;
    }

    public void setNoOfPmsAmfPiuAvailableAtSite(String noOfPmsAmfPiuAvailableAtSite) {
        this.noOfPmsAmfPiuAvailableAtSite = noOfPmsAmfPiuAvailableAtSite;
    }

    public List<PmsAmfPanelCheckPointsDatum> getPmsAmfPanelCheckPointsData() {
        return pmsAmfPanelCheckPointsData;
    }

    public void setPmsAmfPanelCheckPointsData(List<PmsAmfPanelCheckPointsDatum> pmsAmfPanelCheckPointsData) {
        this.pmsAmfPanelCheckPointsData = pmsAmfPanelCheckPointsData;
    }

}
