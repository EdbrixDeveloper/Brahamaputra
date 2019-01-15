
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PmsAmfPanelCheckPointsParentData implements Serializable
{

    @SerializedName("noOfPmsAmfPiuAvailableAtSite")
    @Expose
    private String noOfPmsAmfPiuAvailableAtSite;
    @SerializedName("pmsAmfPanelCheckPointsData")
    @Expose
    private List<PmsAmfPanelCheckPointsData> pmsAmfPanelCheckPointsData = null;

    @SerializedName("isSubmited")
    //private Boolean isSubmited;
    private int isSubmited;

    private final static long serialVersionUID = -6067841024671567130L;
    public PmsAmfPanelCheckPointsParentData()
    {
        this.noOfPmsAmfPiuAvailableAtSite = "";
        this.pmsAmfPanelCheckPointsData = new ArrayList<>();
        isSubmited = 0;
    }
    public PmsAmfPanelCheckPointsParentData(String noOfPmsAmfPuiAvailableAtSite, ArrayList<PmsAmfPanelCheckPointsData> pmsAmfPanelCheckPointsArrayList) {
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

    public List<PmsAmfPanelCheckPointsData> getPmsAmfPanelCheckPointsData() {
        return pmsAmfPanelCheckPointsData;
    }

    public void setPmsAmfPanelCheckPointsData(List<PmsAmfPanelCheckPointsData> pmsAmfPanelCheckPointsData) {
        this.pmsAmfPanelCheckPointsData = pmsAmfPanelCheckPointsData;
    }
    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int submited) {
        isSubmited = submited;
    }
}
