
package com.brahamaputra.mahindra.brahamaputra.Data;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BatteryBankCheckPoint implements Serializable
{

    @SerializedName("detailsOfBatteryBankQrCodeScan")
    @Expose
    private String detailsOfBatteryBankQrCodeScan;
    @SerializedName("batteryBankDischargeTest")
    @Expose
    private String batteryBankDischargeTest;
    @SerializedName("stripBoltTightnessAsPerTorque")
    @Expose
    private String stripBoltTightnessAsPerTorque;
    @SerializedName("petroleumJellyApplied")
    @Expose
    private String petroleumJellyApplied;
    @SerializedName("batteryVentPlugStatus")
    @Expose
    private String batteryVentPlugStatus;
    @SerializedName("bbEarthingStatus")
    @Expose
    private String bbEarthingStatus;
    @SerializedName("registerFault")
    @Expose
    private String registerFault;
    @SerializedName("typeOfFault")
    @Expose
    private String typeOfFault;
    private final static long serialVersionUID = -1304518207815428673L;

    public String getDetailsOfBatteryBankQrCodeScan() {
        return detailsOfBatteryBankQrCodeScan;
    }

    public void setDetailsOfBatteryBankQrCodeScan(String detailsOfBatteryBankQrCodeScan) {
        this.detailsOfBatteryBankQrCodeScan = detailsOfBatteryBankQrCodeScan;
    }

    public String getBatteryBankDischargeTest() {
        return batteryBankDischargeTest;
    }

    public void setBatteryBankDischargeTest(String batteryBankDischargeTest) {
        this.batteryBankDischargeTest = batteryBankDischargeTest;
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
