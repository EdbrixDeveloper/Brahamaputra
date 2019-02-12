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
    //private Boolean isSubmited;
    private int isSubmited;

    public BatterySetParentData() {
        this.noOfBatterySet = "";
        this.noOfBatteryBankWorking = "";
        this.batterySetData = new ArrayList<>();
        this.isSubmited = 0;
    }

    public BatterySetParentData(String noOfBatterySet, String noOfBatteryBankWorking, ArrayList<BatterySetData> batterySetData) {
        this.noOfBatterySet = noOfBatterySet;
        this.noOfBatteryBankWorking = noOfBatteryBankWorking;
        this.batterySetData = batterySetData;
        //this.isSubmited = true;//007
        this.isSubmited = 1;
        if (!this.noOfBatterySet.isEmpty()) {
            this.isSubmited = 2;
        }/* else {
            this.isSubmited = 1;
        }*/
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

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int submited) {
        isSubmited = submited;
    }
}
