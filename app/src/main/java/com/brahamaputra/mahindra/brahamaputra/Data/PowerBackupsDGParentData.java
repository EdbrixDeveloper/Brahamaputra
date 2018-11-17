package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PowerBackupsDGParentData {

    @SerializedName("noOfEngineAlternator")
    String noOfEngineAlternator;

    @SerializedName("numberOfWorkingDg")
    String numberOfWorkingDg;

    @SerializedName("powerBackupsDGData")
    ArrayList<PowerBackupsDGData> powerBackupsDGData;

    @SerializedName("isSubmited")
    private Boolean isSubmited;

    public String getNoOfEngineAlternator() {
        return noOfEngineAlternator;
    }

    public void setNoOfEngineAlternator(String noOfEngineAlternator) {
        this.noOfEngineAlternator = noOfEngineAlternator;
    }

    public String getNumberOfWorkingDg() {
        return numberOfWorkingDg;
    }

    public void setNumberOfWorkingDg(String numberOfWorkingDg) {
        this.numberOfWorkingDg = numberOfWorkingDg;
    }

    public ArrayList<PowerBackupsDGData> getPowerBackupsDGData() {
        return powerBackupsDGData;
    }

    public void setPowerBackupsDGData(ArrayList<PowerBackupsDGData> powerBackupsDGData) {
        this.powerBackupsDGData = powerBackupsDGData;
    }

    public Boolean getSubmited() {
        return isSubmited;
    }

    public void setSubmited(Boolean submited) {
        isSubmited = submited;
    }

    public PowerBackupsDGParentData(String noOfEngineAlternator, String numberOfWorkingDg, ArrayList<PowerBackupsDGData> powerBackupsDGData) {
        this.noOfEngineAlternator = noOfEngineAlternator;
        this.numberOfWorkingDg = numberOfWorkingDg;
        this.powerBackupsDGData = powerBackupsDGData;
        this.isSubmited = true;
    }
    public PowerBackupsDGParentData(){
        this.noOfEngineAlternator = "";
        this.numberOfWorkingDg = "";
        this.powerBackupsDGData = new ArrayList<>();
        this.isSubmited = false;
    }
}
