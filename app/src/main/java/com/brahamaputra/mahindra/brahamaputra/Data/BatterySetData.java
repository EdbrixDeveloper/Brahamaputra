package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

public class BatterySetData {

    @SerializedName("noOfBatterySet")
    private String noOfBatterySet;

    @SerializedName("noOfBatteryBankWorking")
    private String noOfBatteryBankWorking;

    @SerializedName("batterySet_Qr")
    private String batterySet_Qr;

    @SerializedName("assetOwner")
    private String assetOwner;

    @SerializedName("manufactureMakeModel")
    private String manufactureMakeModel;

    @SerializedName("capacityInAH")
    private String capacityInAH;

    @SerializedName("typeOfBattery")
    private String typeOfBattery;

    @SerializedName("dateOfInstallation")
    private String dateOfInstallation;

    @SerializedName("backupDuaration")
    private String backupDuaration;

    @SerializedName("positionOfBatteryBank")
    private String positionOfBatteryBank;

    @SerializedName("batteryBankCableSize")
    private String batteryBankCableSize;

    @SerializedName("batteryBankEarthingStatus")
    private String batteryBankEarthingStatus;

    @SerializedName("backupCondition")
    private String backupCondition;

    @SerializedName("natureOfProblem")
    private String natureOfProblem;

    public BatterySetData(String noOfBatterySet, String noOfBatteryBankWorking, String batterySet_Qr, String assetOwner, String manufactureMakeModel, String capacityInAH, String typeOfBattery, String dateOfInstallation, String backupDuaration, String positionOfBatteryBank, String batteryBankCableSize, String batteryBankEarthingStatus, String backupCondition, String natureOfProblem) {
        this.noOfBatterySet = noOfBatterySet;
        this.noOfBatteryBankWorking = noOfBatteryBankWorking;
        this.batterySet_Qr = batterySet_Qr;
        this.assetOwner = assetOwner;
        this.manufactureMakeModel = manufactureMakeModel;
        this.capacityInAH = capacityInAH;
        this.typeOfBattery = typeOfBattery;
        this.dateOfInstallation = dateOfInstallation;
        this.backupDuaration = backupDuaration;
        this.positionOfBatteryBank = positionOfBatteryBank;
        this.batteryBankCableSize = batteryBankCableSize;
        this.batteryBankEarthingStatus = batteryBankEarthingStatus;
        this.backupCondition = backupCondition;
        this.natureOfProblem = natureOfProblem;
    }

    public String getNoOfBatterySet() {
        return noOfBatterySet;
    }

    public void setNoOfBatterySet(String noOfBatterySet) {
        this.noOfBatterySet = noOfBatterySet;
    }

    public String getNoOfBatteryBankWorking() {
        return noOfBatteryBankWorking;
    }

    public void setNoOfBatteryBankWorking(String noOfBatteryBankWorking) {
        this.noOfBatteryBankWorking = noOfBatteryBankWorking;
    }

    public String getBatterySet_Qr() {
        return batterySet_Qr;
    }

    public void setBatterySet_Qr(String batterySet_Qr) {
        this.batterySet_Qr = batterySet_Qr;
    }

    public String getAssetOwner() {
        return assetOwner;
    }

    public void setAssetOwner(String assetOwner) {
        this.assetOwner = assetOwner;
    }

    public String getManufactureMakeModel() {
        return manufactureMakeModel;
    }

    public void setManufactureMakeModel(String manufactureMakeModel) {
        this.manufactureMakeModel = manufactureMakeModel;
    }

    public String getCapacityInAH() {
        return capacityInAH;
    }

    public void setCapacityInAH(String capacityInAH) {
        this.capacityInAH = capacityInAH;
    }

    public String getTypeOfBattery() {
        return typeOfBattery;
    }

    public void setTypeOfBattery(String typeOfBattery) {
        this.typeOfBattery = typeOfBattery;
    }

    public String getDateOfInstallation() {
        return dateOfInstallation;
    }

    public void setDateOfInstallation(String dateOfInstallation) {
        this.dateOfInstallation = dateOfInstallation;
    }

    public String getBackupDuaration() {
        return backupDuaration;
    }

    public void setBackupDuaration(String backupDuaration) {
        this.backupDuaration = backupDuaration;
    }

    public String getPositionOfBatteryBank() {
        return positionOfBatteryBank;
    }

    public void setPositionOfBatteryBank(String positionOfBatteryBank) {
        this.positionOfBatteryBank = positionOfBatteryBank;
    }

    public String getBatteryBankCableSize() {
        return batteryBankCableSize;
    }

    public void setBatteryBankCableSize(String batteryBankCableSize) {
        this.batteryBankCableSize = batteryBankCableSize;
    }

    public String getBatteryBankEarthingStatus() {
        return batteryBankEarthingStatus;
    }

    public void setBatteryBankEarthingStatus(String batteryBankEarthingStatus) {
        this.batteryBankEarthingStatus = batteryBankEarthingStatus;
    }

    public String getBackupCondition() {
        return backupCondition;
    }

    public void setBackupCondition(String backupCondition) {
        this.backupCondition = backupCondition;
    }

    public String getNatureOfProblem() {
        return natureOfProblem;
    }

    public void setNatureOfProblem(String natureOfProblem) {
        this.natureOfProblem = natureOfProblem;
    }
}
