package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

public class PowerPlantDetailsModulesData implements java.io.Serializable {

    @SerializedName("moduleQrCodeScan")
    String moduleQrCodeScan;

    @SerializedName("moduleMake")
    String moduleMake;

    @SerializedName("moduleCapacity")
    String moduleCapacity;

    public PowerPlantDetailsModulesData(String moduleQrCodeScan, String moduleMake, String moduleCapacity) {
        this.moduleQrCodeScan = moduleQrCodeScan;
        this.moduleMake = moduleMake;
        this.moduleCapacity = moduleCapacity;
    }

    public PowerPlantDetailsModulesData() {
        this.moduleQrCodeScan = "";
        this.moduleMake = "";
        this.moduleCapacity = "";
    }

    public String getModuleQrCodeScan() {
        return moduleQrCodeScan;
    }

    public void setModuleQrCodeScan(String moduleQrCodeScan) {
        this.moduleQrCodeScan = moduleQrCodeScan;
    }

    public String getModuleMake() {
        return moduleMake;
    }

    public void setModuleMake(String moduleMake) {
        this.moduleMake = moduleMake;
    }

    public String getModuleCapacity() {
        return moduleCapacity;
    }

    public void setModuleCapacity(String moduleCapacity) {
        this.moduleCapacity = moduleCapacity;
    }
}
