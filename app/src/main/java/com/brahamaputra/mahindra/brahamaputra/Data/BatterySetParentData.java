package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BatterySetParentData {

    @SerializedName("noOfBatterySet")
    String noOfBatterySet;

    @SerializedName("noOfBatteryBankWorking")
    String noOfBatteryBankWorking;

    @SerializedName("batterySetData")
    ArrayList<BatterySetData> batterySetData;

    @SerializedName("isSubmited")
    private Boolean isSubmited;

    public BatterySetParentData(String noOfBatterySet, String noOfBatteryBankWorking, ArrayList<BatterySetData> batterySetData) {
        this.noOfBatterySet = noOfBatterySet;
        this.noOfBatteryBankWorking = noOfBatteryBankWorking;
        this.batterySetData = batterySetData;
        this.isSubmited = true;
    }
    public BatterySetParentData(){
        this.noOfBatterySet = "";
        this.noOfBatteryBankWorking = "";
        this.batterySetData = new ArrayList<>();
        this.isSubmited = false;
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

    public ArrayList<BatterySetData> getBatterySetData() {
        return batterySetData;
    }

    public void setBatterySetData(ArrayList<BatterySetData> batterySetData) {
        this.batterySetData = batterySetData;
    }

    public Boolean getSubmited() {
        return isSubmited;
    }

    public void setSubmited(Boolean submited) {
        isSubmited = submited;
    }
}
