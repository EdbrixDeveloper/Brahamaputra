
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BatteryBankCheckPointsParentData implements Serializable {

    @SerializedName("noOfBatteryBankAvailableAtSite")
    @Expose
    private String noOfBatteryBankAvailableAtSite;
    @SerializedName("batteryBankCheckPointData")
    @Expose
    private List<BatteryBankCheckPointsData> batteryBankCheckPointsData;
    @SerializedName("isSubmited")
    @Expose
    private int isSubmited = 0;

    //    private final static long serialVersionUID = 791430875205059677L;


    public BatteryBankCheckPointsParentData() {
        this.noOfBatteryBankAvailableAtSite = "";
        this.batteryBankCheckPointsData = new ArrayList<>();
        this.isSubmited = 0;
    }

    public BatteryBankCheckPointsParentData(String noOfBatteryBankAvailableAtSite, List<BatteryBankCheckPointsData> batteryBankCheckPointsData) {
        this.noOfBatteryBankAvailableAtSite = noOfBatteryBankAvailableAtSite;
        this.batteryBankCheckPointsData = batteryBankCheckPointsData;
        this.isSubmited = 2;
    }

    public int getIsSubmited() {
        return isSubmited;
    }

    public void setIsSubmited(int isSubmited) {
        this.isSubmited = isSubmited;
    }

    public String getNoOfBatteryBankAvailableAtSite() {
        return noOfBatteryBankAvailableAtSite;
    }

    public void setNoOfBatteryBankAvailableAtSite(String noOfBatteryBankAvailableAtSite) {
        this.noOfBatteryBankAvailableAtSite = noOfBatteryBankAvailableAtSite;
    }

    public List<BatteryBankCheckPointsData> getBatteryBankCheckPointsData() {
        return batteryBankCheckPointsData;
    }

    public void setBatteryBankCheckPointsData(List<BatteryBankCheckPointsData> batteryBankCheckPointsData) {
        this.batteryBankCheckPointsData = batteryBankCheckPointsData;
    }

}
