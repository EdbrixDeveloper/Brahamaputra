
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import java.util.ArrayList;
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

    @SerializedName("isSubmited")
    //private Boolean isSubmited;
    private int isSubmited;

    private final static long serialVersionUID = -6067841024671567130L;
    public PmsAmfPanelCheckPoints()
    {
        this.noOfPmsAmfPiuAvailableAtSite = "";
        this.pmsAmfPanelCheckPointsData = new ArrayList<>();
        isSubmited = 0;
    }
    public PmsAmfPanelCheckPoints(String noOfPmsAmfPuiAvailableAtSite, ArrayList<PmsAmfPanelCheckPointsDatum> pmsAmfPanelCheckPointsArrayList) {
        this.noOfPmsAmfPiuAvailableAtSite = noOfPmsAmfPuiAvailableAtSite;
        this.pmsAmfPanelCheckPointsData = pmsAmfPanelCheckPointsArrayList;

        if (!this.noOfPmsAmfPiuAvailableAtSite.isEmpty()) {
            this.isSubmited = 2;
        } else {
            this.isSubmited = 1;
        }
    }


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
    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int submited) {
        isSubmited = submited;
    }
}
