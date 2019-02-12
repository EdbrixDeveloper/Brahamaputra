package com.brahamaputra.mahindra.brahamaputra.Data;
import com.google.gson.annotations.SerializedName;

public class EarthResistanceEquipmentData {

    @SerializedName("earthType")
    private String earthType;

    @SerializedName("earthResistanceInOhms")
    private String earthResistanceInOhms;

    @SerializedName("earthResistanceMeasuredDate")
    private String earthResistanceMeasuredDate;

    @SerializedName("isSubmited")
    //private Boolean isSubmited;
    private int isSubmited;

    //region Region of Constructors
    public EarthResistanceEquipmentData() {
        this.earthType = "";
        this.earthResistanceInOhms = "";
        this.earthResistanceMeasuredDate = "";
        this.isSubmited = 0;
    }

    public EarthResistanceEquipmentData(String earthType, String earthResistanceInOhms, String earthResistanceMeasuredDate) {
        this.earthType = earthType;
        this.earthResistanceInOhms = earthResistanceInOhms;
        this.earthResistanceMeasuredDate = earthResistanceMeasuredDate;
        //this.isSubmited=true;//007
        this.isSubmited = 1;
        if (!this.earthType.isEmpty() && !this.earthResistanceInOhms.isEmpty() && !this.earthResistanceMeasuredDate.isEmpty()) {
            this.isSubmited = 2;
        }/*else {
            this.isSubmited = 1;
        }*/
    }
    //endregion

    //region Region Of Getter() Setter() Properties
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

    public int getSubmited() {
        return isSubmited;
    }

    public void setSubmited(int submited) {
        isSubmited = submited;
    }
    //endregion
}
