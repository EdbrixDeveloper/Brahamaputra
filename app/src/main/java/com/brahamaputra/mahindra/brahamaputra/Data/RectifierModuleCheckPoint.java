
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RectifierModuleCheckPoint implements Serializable
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
    private List<RectifierModuleCheckPointDatum> rectifierModuleCheckPointData = null;
    private final static long serialVersionUID = 1961740297699264464L;

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

    public List<RectifierModuleCheckPointDatum> getRectifierModuleCheckPointData() {
        return rectifierModuleCheckPointData;
    }

    public void setRectifierModuleCheckPointData(List<RectifierModuleCheckPointDatum> rectifierModuleCheckPointData) {
        this.rectifierModuleCheckPointData = rectifierModuleCheckPointData;
    }

}
