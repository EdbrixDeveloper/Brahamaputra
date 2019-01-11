
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DgBatteryCheckPoints implements Serializable
{

    @SerializedName("noOfDgBatteryavailableAtSite")
    @Expose
    private String noOfDgBatteryavailableAtSite;
    @SerializedName("dgBatteryCheckPointsData")
    @Expose
    private List<DgBatteryCheckPointsDatum> dgBatteryCheckPointsData = null;
    private final static long serialVersionUID = -7106565427034794128L;

    public String getNoOfDgBatteryavailableAtSite() {
        return noOfDgBatteryavailableAtSite;
    }

    public void setNoOfDgBatteryavailableAtSite(String noOfDgBatteryavailableAtSite) {
        this.noOfDgBatteryavailableAtSite = noOfDgBatteryavailableAtSite;
    }

    public List<DgBatteryCheckPointsDatum> getDgBatteryCheckPointsData() {
        return dgBatteryCheckPointsData;
    }

    public void setDgBatteryCheckPointsData(List<DgBatteryCheckPointsDatum> dgBatteryCheckPointsData) {
        this.dgBatteryCheckPointsData = dgBatteryCheckPointsData;
    }

}
