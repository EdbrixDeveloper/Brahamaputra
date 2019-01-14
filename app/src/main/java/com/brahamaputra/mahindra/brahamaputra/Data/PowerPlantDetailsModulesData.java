package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

public class PowerPlantDetailsModulesData implements java.io.Serializable {

    @SerializedName("moduleQrCodeScan")
    String moduleQrCodeScan;

    @SerializedName("moduleMake")
    String moduleMake;

    @SerializedName("moduleCapacity")
    String moduleCapacity;

    @SerializedName("bookValueModules")
    String bookValueModules;

    public String getBookValueModules() {
        return bookValueModules;
    }

    public void setBookValueModules(String bookValueModules) {
        this.bookValueModules = bookValueModules;
    }

    public PowerPlantDetailsModulesData(String moduleQrCodeScan, String moduleMake, String moduleCapacity,String bookValueModules) {
        this.moduleQrCodeScan = moduleQrCodeScan;
        this.moduleMake = moduleMake;
        this.moduleCapacity = moduleCapacity;
        this.bookValueModules = bookValueModules;
    }

    public PowerPlantDetailsModulesData() {
        this.moduleQrCodeScan = "";
        this.moduleMake = "";
        this.moduleCapacity = "";
        this.bookValueModules = "";
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
