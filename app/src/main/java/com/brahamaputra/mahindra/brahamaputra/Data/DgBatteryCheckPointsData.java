package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DgBatteryCheckPointsData implements Serializable {

    @SerializedName("detailsOfDgBatteryQrCodeScan")
    @Expose
    private String detailsOfDgBatteryQrCodeScan;

    @SerializedName("dgBatteryCondition")
    @Expose
    private String dgBatteryCondition;
    @SerializedName("dgBatteryWaterAvailable")
    @Expose
    private String dgBatteryWaterAvailable;
    @SerializedName("petroleumJellyToDgBatteryTerminal")
    @Expose
    private String petroleumJellyToDgBatteryTerminal;
    @SerializedName("dgBatteryCharger")
    @Expose
    private String dgBatteryCharger;
    @SerializedName("isQrCodeNew")
    @Expose
    private int isQrCodeNew = 0;

    public DgBatteryCheckPointsData() {
        this.detailsOfDgBatteryQrCodeScan = "";
        this.dgBatteryCondition = "";
        this.dgBatteryWaterAvailable = "";
        this.petroleumJellyToDgBatteryTerminal = "";
        this.dgBatteryCharger = "";

    }

    public DgBatteryCheckPointsData(String detailsOfDgBatteryQrCodeScan, String dgBatteryCondition, String dgBatteryWaterAvailable,
                                    String petroleumJellyToDgBatteryTerminal, String dgBatteryCharger, int isQrCodeNew) {
        this.detailsOfDgBatteryQrCodeScan = detailsOfDgBatteryQrCodeScan;
        this.dgBatteryCondition = dgBatteryCondition;
        this.dgBatteryWaterAvailable = dgBatteryWaterAvailable;
        this.petroleumJellyToDgBatteryTerminal = petroleumJellyToDgBatteryTerminal;
        this.dgBatteryCharger = dgBatteryCharger;

    }

    public String getDetailsOfDgBatteryQrCodeScan() {
        return detailsOfDgBatteryQrCodeScan;
    }

    public void setDetailsOfDgBatteryQrCodeScan(String detailsOfDgBatteryQrCodeScan) {
        this.detailsOfDgBatteryQrCodeScan = detailsOfDgBatteryQrCodeScan;
    }

    public String getDgBatteryCondition() {
        return dgBatteryCondition;
    }

    public void setDgBatteryCondition(String dgBatteryCondition) {
        this.dgBatteryCondition = dgBatteryCondition;
    }

    public String getDgBatteryWaterAvailable() {
        return dgBatteryWaterAvailable;
    }

    public void setDgBatteryWaterAvailable(String dgBatteryWaterAvailable) {
        this.dgBatteryWaterAvailable = dgBatteryWaterAvailable;
    }

    public String getPetroleumJellyToDgBatteryTerminal() {
        return petroleumJellyToDgBatteryTerminal;
    }

    public void setPetroleumJellyToDgBatteryTerminal(String petroleumJellyToDgBatteryTerminal) {
        this.petroleumJellyToDgBatteryTerminal = petroleumJellyToDgBatteryTerminal;
    }

    public String getDgBatteryCharger() {
        return dgBatteryCharger;
    }

    public void setDgBatteryCharger(String dgBatteryCharger) {
        this.dgBatteryCharger = dgBatteryCharger;
    }
    public int getIsQrCodeNew() {
        return isQrCodeNew;
    }

    public void setIsQrCodeNew(int isQrCodeNew) {
        this.isQrCodeNew = isQrCodeNew;
    }
}
