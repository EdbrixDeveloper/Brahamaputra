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
    @SerializedName("CapacityInAH")
    @Expose
    private String capacityInAH;
    @SerializedName("ManufactureMakeModel")
    @Expose
    private String manufactureMakeModel;
    @SerializedName("NoOfRectifireModuleWorking")
    @Expose
    private String noOfRectifireModuleWorking;
    @SerializedName("NoOfBatteryModule")
    @Expose
    private String noOfBatteryModule;


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

    public String getCapacityInAH() {
        return capacityInAH;
    }

    public void setCapacityInAH(String capacityInAH) {
        this.capacityInAH = capacityInAH;
    }

    public String getManufactureMakeModel() {
        return manufactureMakeModel;
    }

    public void setManufactureMakeModel(String manufactureMakeModel) {
        this.manufactureMakeModel = manufactureMakeModel;
    }

    public String getNoOfRectifireModuleWorking() {
        return noOfRectifireModuleWorking;
    }

    public void setNoOfRectifireModuleWorking(String noOfRectifireModuleWorking) {
        this.noOfRectifireModuleWorking = noOfRectifireModuleWorking;
    }

    public String getNoOfBatteryModule() {
        return noOfBatteryModule;
    }

    public void setNoOfBatteryModule(String noOfBatteryModule) {
        this.noOfBatteryModule = noOfBatteryModule;
    }

}
