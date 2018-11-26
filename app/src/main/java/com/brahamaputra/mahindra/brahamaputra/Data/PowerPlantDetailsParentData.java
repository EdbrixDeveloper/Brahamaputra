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
    private Boolean isSubmited;

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

    public Boolean getSubmited() {
        return isSubmited;
    }

    public void setSubmited(Boolean submited) {
        isSubmited = submited;
    }

    public PowerPlantDetailsParentData(String numberOfPowerPlant, String numberOfWorkingPowerPlant, ArrayList<PowerPlantDetailsData> powerPlantDetailsData) {
        this.numberOfPowerPlant = numberOfPowerPlant;
        this.numberOfWorkingPowerPlant = numberOfWorkingPowerPlant;
        this.powerPlantDetailsData = powerPlantDetailsData;
        this.isSubmited = true;
    }

    public PowerPlantDetailsParentData() {
        this.numberOfPowerPlant = "";
        this.numberOfWorkingPowerPlant = "";
        this.powerPlantDetailsData = new ArrayList<>();
        this.isSubmited = false;
    }

    public String getNumberOfWorkingPowerPlant() {
        return numberOfWorkingPowerPlant;
    }

    public void setNumberOfWorkingPowerPlant(String numberOfWorkingPowerPlant) {
        this.numberOfWorkingPowerPlant = numberOfWorkingPowerPlant;
    }
}
