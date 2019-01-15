
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DgBatteryCheckPointsData implements Serializable
{

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
    @SerializedName("registerFault")
    @Expose
    private String registerFault;
    @SerializedName("typeOfFault")
    @Expose
    private String typeOfFault;
    private final static long serialVersionUID = -7689901156568939001L;

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

    public String getRegisterFault() {
        return registerFault;
    }

    public void setRegisterFault(String registerFault) {
        this.registerFault = registerFault;
    }

    public String getTypeOfFault() {
        return typeOfFault;
    }

    public void setTypeOfFault(String typeOfFault) {
        this.typeOfFault = typeOfFault;
    }

}
