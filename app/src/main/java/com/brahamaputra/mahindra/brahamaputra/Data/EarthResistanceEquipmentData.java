package com.brahamaputra.mahindra.brahamaputra.Data;

public class EarthResistanceEquipmentData {

    private String earthType;
    private String earthResistanceInOhms;
    private String earthResistanceMeasuredDate;

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
