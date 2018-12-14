package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PowerPlantDetailsParentData {

    @SerializedName("numberOfPowerPlant")
    String numberOfPowerPlant;

    @SerializedName("numberOfWorkingPowerPlant")
    String numberOfWorkingPowerPlant;

    @SerializedName("powerPlantDetailsData")
    ArrayList<PowerPlantDetailsData> powerPlantDetailsData;

    @SerializedName("isSubmited")
    //private Boolean isSubmited;
    private int isSubmited;

    public PowerPlantDetailsParentData() {
        this.numberOfPowerPlant = "";
        this.numberOfWorkingPowerPlant = "";
        this.powerPlantDetailsData = new ArrayList<>();
        this.isSubmited = 0;
    }

    public PowerPlantDetailsParentData(String numberOfPowerPlant, String numberOfWorkingPowerPlant, ArrayList<PowerPlantDetailsData> powerPlantDetailsData) {
        this.numberOfPowerPlant = numberOfPowerPlant;
        this.numberOfWorkingPowerPlant = numberOfWorkingPowerPlant;
        this.powerPlantDetailsData = powerPlantDetailsData;
        //this.isSubmited = true;//007
        this.isSubmited = 1;
        if (!this.numberOfPowerPlant.isEmpty()) {
            this.isSubmited = 2;
        }/*else {
            this.isSubmited = 1;
        }*/
    }

    public String getNumberOfPowerPlant() {
        return numberOfPowerPlant;
    }

    public void setNumberOfPowerPlant(String numberOfPowerPlant) {
        this.numberOfPowerPlant = numberOfPowerPlant;
    }

    public ArrayList<PowerPlantDetailsData> getPowerPlantDetailsData() {
        return powerPlantDetailsData;
    }

    public void setPowerPlantDetailsData(ArrayList<PowerPlantDetailsData> powerPlantDetailsData) {
        this.powerPlantDetailsData = powerPlantDetailsData;
    }

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int submited) {
        isSubmited = submited;
    }

    public String getNumberOfWorkingPowerPlant() {
        return numberOfWorkingPowerPlant;
    }

    public void setNumberOfWorkingPowerPlant(String numberOfWorkingPowerPlant) {
        this.numberOfWorkingPowerPlant = numberOfWorkingPowerPlant;
    }
}
