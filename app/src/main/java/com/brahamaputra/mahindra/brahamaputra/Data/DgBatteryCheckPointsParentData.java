
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DgBatteryCheckPointsParentData implements Serializable {

    @SerializedName("noOfDgBatteryavailableAtSite")
    @Expose
    private String noOfDgBatteryavailableAtSite;
    @SerializedName("dgBatteryCheckPointsData")
    @Expose
    private List<DgBatteryCheckPointsData> dgBatteryCheckPointsData;
    //private final static long serialVersionUID = -7106565427034794128L;

    @SerializedName("isSubmited")
    @Expose
    private int isSubmited = 0;

    public DgBatteryCheckPointsParentData() {
        this.noOfDgBatteryavailableAtSite = "";
        this.dgBatteryCheckPointsData = new ArrayList<>();
        this.isSubmited = 0;
    }

    public DgBatteryCheckPointsParentData(String noOfDgBatteryavailableAtSite, List<DgBatteryCheckPointsData> dgBatteryCheckPointsData) {
        this.noOfDgBatteryavailableAtSite = noOfDgBatteryavailableAtSite;
        this.dgBatteryCheckPointsData = dgBatteryCheckPointsData;
        if(!this.noOfDgBatteryavailableAtSite.isEmpty())
        {
            this.isSubmited = 2;
        }
        else
        {
            this.isSubmited = 1;
        }
    }

    public String getNoOfDgBatteryavailableAtSite() {
        return noOfDgBatteryavailableAtSite;
    }

    public void setNoOfDgBatteryavailableAtSite(String noOfDgBatteryavailableAtSite) {
        this.noOfDgBatteryavailableAtSite = noOfDgBatteryavailableAtSite;
    }

    public List<DgBatteryCheckPointsData> getDgBatteryCheckPointsData() {
        return dgBatteryCheckPointsData;
    }

    public void setDgBatteryCheckPointsData(List<DgBatteryCheckPointsData> dgBatteryCheckPointsData) {
        this.dgBatteryCheckPointsData = dgBatteryCheckPointsData;
    }

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int isSubmited) {
        this.isSubmited = isSubmited;
    }

}
