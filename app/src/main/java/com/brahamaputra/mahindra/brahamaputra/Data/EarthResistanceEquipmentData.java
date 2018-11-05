package com.brahamaputra.mahindra.brahamaputra.Data;

import com.google.gson.annotations.SerializedName;

public class EarthResistanceEquipmentData {

    @SerializedName("earthType")
    private String earthType;

    @SerializedName("earthResistanceInOhms")
    private String earthResistanceInOhms;

    @SerializedName("earthResistanceMeasuredDate")
    private String earthResistanceMeasuredDate;

    public EarthResistanceEquipmentData() {
    }

    public EarthResistanceEquipmentData(String earthType, String earthResistanceInOhms, String earthResistanceMeasuredDate) {
        this.earthType = earthType;
        this.earthResistanceInOhms = earthResistanceInOhms;
        this.earthResistanceMeasuredDate = earthResistanceMeasuredDate;
    }

    public String getEarthType() {
        return earthType;
    }

    public void setEarthType(String earthType) {
        this.earthType = earthType;
    }

    public String getEarthResistanceInOhms() {
        return earthResistanceInOhms;
    }

    public void setEarthResistanceInOhms(String earthResistanceInOhms) {
        this.earthResistanceInOhms = earthResistanceInOhms;
    }

    public String getEarthResistanceMeasuredDate() {
        return earthResistanceMeasuredDate;
    }

    public void setEarthResistanceMeasuredDate(String earthResistanceMeasuredDate) {
        this.earthResistanceMeasuredDate = earthResistanceMeasuredDate;
    }
}
