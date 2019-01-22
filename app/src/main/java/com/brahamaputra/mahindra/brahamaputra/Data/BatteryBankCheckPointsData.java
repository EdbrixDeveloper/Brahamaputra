
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BatteryBankCheckPointsData implements Serializable {

    @SerializedName("detailsOfBatteryBankQrCodeScan")
    @Expose
    private String detailsOfBatteryBankQrCodeScan;

    @SerializedName("stripBoltTightnessAsPerTorque")
    @Expose
    private String stripBoltTightnessAsPerTorque;
    @SerializedName("petroleumJellyApplied")
    @Expose
    private String petroleumJellyApplied;
    /*@SerializedName("batteryCharger")
    @Expose
    private String batteryCharger;*/
    @SerializedName("batteryVentPlugStatus")
    @Expose
    private String batteryVentPlugStatus;
    @SerializedName("bbEarthingStatus")
    @Expose
    private String bbEarthingStatus;

    public BatteryBankCheckPointsData() {
        this.detailsOfBatteryBankQrCodeScan = "";
        this.stripBoltTightnessAsPerTorque = "";
        this.petroleumJellyApplied = "";
        //this.batteryCharger = "";
        this.batteryVentPlugStatus = "";
        this.bbEarthingStatus = "";

    }

    public BatteryBankCheckPointsData(String detailsOfBatteryBankQrCodeScan, String stripBoltTightnessAsPerTorque,
                                      String petroleumJellyApplied, String batteryVentPlugStatus, String bbEarthingStatus
    ) {
        this.detailsOfBatteryBankQrCodeScan = detailsOfBatteryBankQrCodeScan;
        this.stripBoltTightnessAsPerTorque = stripBoltTightnessAsPerTorque;
        this.petroleumJellyApplied = petroleumJellyApplied;
        this.batteryVentPlugStatus = batteryVentPlugStatus;
        this.bbEarthingStatus = bbEarthingStatus;

    }

    public String getDetailsOfBatteryBankQrCodeScan() {
        return detailsOfBatteryBankQrCodeScan;
    }

    public void setDetailsOfBatteryBankQrCodeScan(String detailsOfBatteryBankQrCodeScan) {
        this.detailsOfBatteryBankQrCodeScan = detailsOfBatteryBankQrCodeScan;
    }

    public String getStripBoltTightnessAsPerTorque() {
        return stripBoltTightnessAsPerTorque;
    }

    public void setStripBoltTightnessAsPerTorque(String stripBoltTightnessAsPerTorque) {
        this.stripBoltTightnessAsPerTorque = stripBoltTightnessAsPerTorque;
    }

    public String getPetroleumJellyApplied() {
        return petroleumJellyApplied;
    }

    public void setPetroleumJellyApplied(String petroleumJellyApplied) {
        this.petroleumJellyApplied = petroleumJellyApplied;
    }

    /*public String getBatteryCharger() {
        return batteryCharger;
    }

    public void setBatteryCharger(String batteryCharger) {
        this.batteryCharger = batteryCharger;
    }*/

    public String getBatteryVentPlugStatus() {
        return batteryVentPlugStatus;
    }

    public void setBatteryVentPlugStatus(String batteryVentPlugStatus) {
        this.batteryVentPlugStatus = batteryVentPlugStatus;
    }

    public String getBbEarthingStatus() {
        return bbEarthingStatus;
    }

    public void setBbEarthingStatus(String bbEarthingStatus) {
        this.bbEarthingStatus = bbEarthingStatus;
    }

}

