package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AirConditionParentData {

    @SerializedName("noOfACprovided")
    String noOfACprovided;

    @SerializedName("numberOfACInWorkingCondition")
    String numberOfACInWorkingCondition;

    @SerializedName("AirConditionData")
    ArrayList<AirConditionersData> airConditionersData;

    @SerializedName("isSubmited")
    private Boolean isSubmited;

    public Boolean getSubmited() {
        return isSubmited;
    }

    public void setSubmited(Boolean submited) {
        isSubmited = submited;
    }

    public AirConditionParentData(String noOfACprovided, String numberOfACInWorkingCondition, ArrayList<AirConditionersData> airConditionersData) {
        this.noOfACprovided = noOfACprovided;
        this.numberOfACInWorkingCondition = numberOfACInWorkingCondition;
        this.airConditionersData = airConditionersData;
        this.isSubmited = true;
    }

    public AirConditionParentData(){
        this.noOfACprovided = "";
        this.numberOfACInWorkingCondition = "";
        this.airConditionersData = new ArrayList<>();
        this.isSubmited = false;
    }

    public String getNoOfACprovided() {
        return noOfACprovided;
    }

    public void setNoOfACprovided(String noOfACprovided) {
        this.noOfACprovided = noOfACprovided;
    }

    public String getNumberOfACInWorkingCondition() {
        return numberOfACInWorkingCondition;
    }

    public void setNumberOfACInWorkingCondition(String numberOfACInWorkingCondition) {
        this.numberOfACInWorkingCondition = numberOfACInWorkingCondition;
    }

    public ArrayList<AirConditionersData> getAirConditionersData() {
        return airConditionersData;
    }

    public void setAirConditionersData(ArrayList<AirConditionersData> airConditionersData) {
        this.airConditionersData = airConditionersData;
    }
}