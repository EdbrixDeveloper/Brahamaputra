
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BatteryBankCheckPoints implements Serializable
{

    @SerializedName("noOfBatteryBankAvailableAtSite")
    @Expose
    private String noOfBatteryBankAvailableAtSite;
    @SerializedName("batteryBankCheckPoints")
    @Expose
    private List<BatteryBankCheckPoint> batteryBankCheckPoints = null;
    private final static long serialVersionUID = -2310012795539649287L;

    public String getNoOfBatteryBankAvailableAtSite() {
        return noOfBatteryBankAvailableAtSite;
    }

    public void setNoOfBatteryBankAvailableAtSite(String noOfBatteryBankAvailableAtSite) {
        this.noOfBatteryBankAvailableAtSite = noOfBatteryBankAvailableAtSite;
    }

    public List<BatteryBankCheckPoint> getBatteryBankCheckPoints() {
        return batteryBankCheckPoints;
    }

    public void setBatteryBankCheckPoints(List<BatteryBankCheckPoint> batteryBankCheckPoints) {
        this.batteryBankCheckPoints = batteryBankCheckPoints;
    }

}
