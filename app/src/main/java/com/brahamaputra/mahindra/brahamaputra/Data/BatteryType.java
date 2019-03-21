package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BatteryType implements java.io.Serializable {

    @SerializedName("QRCodeScan")
    @Expose
    private String qRCodeScan;
    @SerializedName("TypeOfBattery")
    @Expose
    private String typeOfBattery;

    public String getQRCodeScan() {
        return qRCodeScan;
    }

    public void setQRCodeScan(String qRCodeScan) {
        this.qRCodeScan = qRCodeScan;
    }

    public String getTypeOfBattery() {
        return typeOfBattery;
    }

    public void setTypeOfBattery(String typeOfBattery) {
        this.typeOfBattery = typeOfBattery;
    }
}
