
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RectifierModuleCheckPointParentData implements Serializable
{

    @SerializedName("noOfRectifierModuleAvailableAtSite")
    @Expose
    private String noOfRectifierModuleAvailableAtSite;
    @SerializedName("noOfModulesWorking")
    @Expose
    private String noOfModulesWorking;
    @SerializedName("noOfFaultyModulesInSite")
    @Expose
    private String noOfFaultyModulesInSite;
    @SerializedName("rectifierModuleCheckPointData")
    @Expose
    private List<RectifierModuleCheckPointData> rectifierModuleCheckPointData = null;

    @SerializedName("isSubmited")
    //private Boolean isSubmited;
    private int isSubmited = 0;
    private final static long serialVersionUID = 1961740297699264464L;

    public RectifierModuleCheckPointParentData()
    {
        this.noOfRectifierModuleAvailableAtSite = "";
        this.noOfModulesWorking = "";
        this.noOfFaultyModulesInSite = "";
        this.rectifierModuleCheckPointData = null;
        this.isSubmited = 0;
    }

    public RectifierModuleCheckPointParentData(String noOfRectifierModuleAvailableAtSite, String noOfModulesWorking, String noOfFaultyModulesAtSite, ArrayList<RectifierModuleCheckPointData> rectifierModuleCheckPointDataList) {
        this.noOfRectifierModuleAvailableAtSite = noOfRectifierModuleAvailableAtSite;
        this.noOfModulesWorking = noOfModulesWorking;
        this.noOfFaultyModulesInSite = noOfFaultyModulesAtSite;
        this.rectifierModuleCheckPointData = rectifierModuleCheckPointDataList;
        if (!this.noOfRectifierModuleAvailableAtSite.isEmpty()) {
            this.isSubmited = 2;
        } else {
            this.isSubmited = 1;
        }
    }

    public String getNoOfRectifierModuleAvailableAtSite() {
        return noOfRectifierModuleAvailableAtSite;
    }

    public void setNoOfRectifierModuleAvailableAtSite(String noOfRectifierModuleAvailableAtSite) {
        this.noOfRectifierModuleAvailableAtSite = noOfRectifierModuleAvailableAtSite;
    }

    public String getNoOfModulesWorking() {
        return noOfModulesWorking;
    }

    public void setNoOfModulesWorking(String noOfModulesWorking) {
        this.noOfModulesWorking = noOfModulesWorking;
    }

    public String getNoOfFaultyModulesInSite() {
        return noOfFaultyModulesInSite;
    }

    public void setNoOfFaultyModulesInSite(String noOfFaultyModulesInSite) {
        this.noOfFaultyModulesInSite = noOfFaultyModulesInSite;
    }

    public List<RectifierModuleCheckPointData> getRectifierModuleCheckPointData() {
        return rectifierModuleCheckPointData;
    }

    public void setRectifierModuleCheckPointData(List<RectifierModuleCheckPointData> rectifierModuleCheckPointData) {
        this.rectifierModuleCheckPointData = rectifierModuleCheckPointData;
    }

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int submited) {
        isSubmited = submited;
    }
}
