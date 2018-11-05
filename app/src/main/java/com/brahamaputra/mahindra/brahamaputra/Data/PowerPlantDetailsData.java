package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

public class PowerPlantDetailsData {

    @SerializedName("qRCodeScan")
    String qRCodeScan;

    @SerializedName("assetOwner")
    String assetOwner;

    @SerializedName("numberOfPowerPlant")
    String numberOfPowerPlant;

    @SerializedName("manufacturerMakeModel")
    String manufacturerMakeModel;

    @SerializedName("powerPlantModel")
    String powerPlantModel;

    @SerializedName("numberModuleSlots")
    String numberModuleSlots;

    @SerializedName("earthingStatus")
    String earthingStatus;

    @SerializedName("dcLoadInDisplay")
    String dcLoadInDisplay;

    @SerializedName("serialNumber")
    String serialNumber;

    @SerializedName("typeOfPowerPlantCommercialSmps")
    String typeOfPowerPlantCommercialSmps;

    @SerializedName("capacityInAmp")
    String capacityInAmp;

    @SerializedName("numberOfModules")
    String numberOfModules;

    @SerializedName("noOfFaultyModulese")
    String noOfFaultyModulese;

    @SerializedName("smpsExpandable")
    String smpsExpandable;

    @SerializedName("SmpsUltimateCapacity")
    String SmpsUltimateCapacity;

    @SerializedName("spdStatus")
    String spdStatus;

    @SerializedName("workingCondition")
    String workingCondition;

    @SerializedName("natureOfProblem")
    String natureOfProblem;

    public PowerPlantDetailsData() {
    }

    public PowerPlantDetailsData(String qRCodeScan, String assetOwner, String numberOfPowerPlant, String manufacturerMakeModel, String powerPlantModel, String numberModuleSlots, String earthingStatus, String dcLoadInDisplay, String serialNumber, String typeOfPowerPlantCommercialSmps, String capacityInAmp, String numberOfModules, String noOfFaultyModulese, String smpsExpandable, String smpsUltimateCapacity, String spdStatus, String workingCondition, String natureOfProblem) {
        this.qRCodeScan = qRCodeScan;
        this.assetOwner = assetOwner;
        this.numberOfPowerPlant = numberOfPowerPlant;
        this.manufacturerMakeModel = manufacturerMakeModel;
        this.powerPlantModel = powerPlantModel;
        this.numberModuleSlots = numberModuleSlots;
        this.earthingStatus = earthingStatus;
        this.dcLoadInDisplay = dcLoadInDisplay;
        this.serialNumber = serialNumber;
        this.typeOfPowerPlantCommercialSmps = typeOfPowerPlantCommercialSmps;
        this.capacityInAmp = capacityInAmp;
        this.numberOfModules = numberOfModules;
        this.noOfFaultyModulese = noOfFaultyModulese;
        this.smpsExpandable = smpsExpandable;
        SmpsUltimateCapacity = smpsUltimateCapacity;
        this.spdStatus = spdStatus;
        this.workingCondition = workingCondition;
        this.natureOfProblem = natureOfProblem;
    }

    public String getqRCodeScan() {
        return qRCodeScan;
    }

    public void setqRCodeScan(String qRCodeScan) {
        this.qRCodeScan = qRCodeScan;
    }

    public String getAssetOwner() {
        return assetOwner;
    }

    public void setAssetOwner(String assetOwner) {
        this.assetOwner = assetOwner;
    }

    public String getNumberOfPowerPlant() {
        return numberOfPowerPlant;
    }

    public void setNumberOfPowerPlant(String numberOfPowerPlant) {
        this.numberOfPowerPlant = numberOfPowerPlant;
    }

    public String getManufacturerMakeModel() {
        return manufacturerMakeModel;
    }

    public void setManufacturerMakeModel(String manufacturerMakeModel) {
        this.manufacturerMakeModel = manufacturerMakeModel;
    }

    public String getPowerPlantModel() {
        return powerPlantModel;
    }

    public void setPowerPlantModel(String powerPlantModel) {
        this.powerPlantModel = powerPlantModel;
    }

    public String getNumberModuleSlots() {
        return numberModuleSlots;
    }

    public void setNumberModuleSlots(String numberModuleSlots) {
        this.numberModuleSlots = numberModuleSlots;
    }

    public String getEarthingStatus() {
        return earthingStatus;
    }

    public void setEarthingStatus(String earthingStatus) {
        this.earthingStatus = earthingStatus;
    }

    public String getDcLoadInDisplay() {
        return dcLoadInDisplay;
    }

    public void setDcLoadInDisplay(String dcLoadInDisplay) {
        this.dcLoadInDisplay = dcLoadInDisplay;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getTypeOfPowerPlantCommercialSmps() {
        return typeOfPowerPlantCommercialSmps;
    }

    public void setTypeOfPowerPlantCommercialSmps(String typeOfPowerPlantCommercialSmps) {
        this.typeOfPowerPlantCommercialSmps = typeOfPowerPlantCommercialSmps;
    }

    public String getCapacityInAmp() {
        return capacityInAmp;
    }

    public void setCapacityInAmp(String capacityInAmp) {
        this.capacityInAmp = capacityInAmp;
    }

    public String getNumberOfModules() {
        return numberOfModules;
    }

    public void setNumberOfModules(String numberOfModules) {
        this.numberOfModules = numberOfModules;
    }

    public String getNoOfFaultyModulese() {
        return noOfFaultyModulese;
    }

    public void setNoOfFaultyModulese(String noOfFaultyModulese) {
        this.noOfFaultyModulese = noOfFaultyModulese;
    }

    public String getSmpsExpandable() {
        return smpsExpandable;
    }

    public void setSmpsExpandable(String smpsExpandable) {
        this.smpsExpandable = smpsExpandable;
    }

    public String getSmpsUltimateCapacity() {
        return SmpsUltimateCapacity;
    }

    public void setSmpsUltimateCapacity(String smpsUltimateCapacity) {
        SmpsUltimateCapacity = smpsUltimateCapacity;
    }

    public String getSpdStatus() {
        return spdStatus;
    }

    public void setSpdStatus(String spdStatus) {
        this.spdStatus = spdStatus;
    }

    public String getWorkingCondition() {
        return workingCondition;
    }

    public void setWorkingCondition(String workingCondition) {
        this.workingCondition = workingCondition;
    }

    public String getNatureOfProblem() {
        return natureOfProblem;
    }

    public void setNatureOfProblem(String natureOfProblem) {
        this.natureOfProblem = natureOfProblem;
    }

}
